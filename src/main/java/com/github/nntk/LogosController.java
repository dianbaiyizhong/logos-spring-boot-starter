package com.github.nntk;

import cn.hutool.core.io.FileUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "logos/rest")
@ResponseBody

public class LogosController {

    @Value("${logos.path}")
    private String logPath;


    @RequestMapping(value = "/listYear", method = RequestMethod.GET)
    public Object year() {

        List<File> fileList = Arrays.asList(FileUtil.ls(logPath + "/info"));

        List<LogosFileObject> ret = fileList.stream()
                .filter(file ->
                        file.isDirectory())
                .map(file ->
                        LogosFileObject.builder()
                                .name(file.getName())
                                .lastModifiedTime(file.lastModified())
                                .size(FileUtils.sizeOfDirectory(file))
                                .build())
                .collect(Collectors.toList());

        return ret;
    }


    @RequestMapping(value = "/{year}", method = RequestMethod.GET)
    public Object month(@PathVariable String year) {

        List<File> fileList = Arrays.asList(FileUtil.ls(logPath + "/info/" + year));

        List<LogosFileObject> ret = fileList.stream()
                .filter(file ->
                        file.isDirectory())
                .map(file ->
                        LogosFileObject.builder()
                                .name(file.getName())
                                .lastModifiedTime(file.lastModified())
                                .size(FileUtils.sizeOfDirectory(file))
                                .build())
                .collect(Collectors.toList());

        return ret;
    }


    @RequestMapping(value = "/{year}/{month}", method = RequestMethod.GET)
    public Object logFile(@PathVariable String year, @PathVariable String month) {

        List<File> fileList = Arrays.asList(FileUtil.ls(logPath + "/info/" + year + "/" + month));

        List<LogosFileObject> ret = fileList.stream()
                .filter(file ->
                        !file.isDirectory())
                .map(file ->
                        LogosFileObject.builder()
                                .name(file.getName())
                                .lastModifiedTime(file.lastModified())
                                .size(file.length())
                                .build())
                .collect(Collectors.toList());

        return ret;
    }
}
