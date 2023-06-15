package com.lk.socket.chatting.service;

import com.lk.socket.chatting.repository.ChattingRepository;
import com.lk.socket.chatting.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChattingService {

    private final ChattingRepository chattingRepository;

    public String getColorById(String simpSessionId) {
        if (chattingRepository.isContainsKey(simpSessionId)) {
            return chattingRepository.getColorById(simpSessionId);
        }
        // A값 0.7 로 임의 고정(끝자리 b3)
        var hexInt = new Random(System.currentTimeMillis()).nextInt(0xffffff + 1);
        var colorHexCode = String.format("#%06xb3", hexInt);
        chattingRepository.putColor(simpSessionId, colorHexCode);
        return colorHexCode;
    }

    public List<String> getResizeImgSrcList(List<String> imgSrcList) {
        return imgSrcList.stream().map(imgSrc -> {
            var bufferedImage = ImageUtil.base64Img(imgSrc);
            var reWidth = 400;
            var reHeight = 0;
            if (bufferedImage != null && bufferedImage.getWidth() > reWidth) {
                reHeight = (int) (400.0 / bufferedImage.getWidth() * bufferedImage.getHeight());
            } else {
                reWidth = bufferedImage.getWidth();
                reHeight = bufferedImage.getHeight();
            }
            var type = imgSrc.substring(imgSrc.indexOf("/") + 1, imgSrc.indexOf(";"));
            var resizeImage = ImageUtil.resize(bufferedImage, reWidth, reHeight);
            return ImageUtil.imgBase64(resizeImage, type);
        }).collect(Collectors.toList());
    }

}
