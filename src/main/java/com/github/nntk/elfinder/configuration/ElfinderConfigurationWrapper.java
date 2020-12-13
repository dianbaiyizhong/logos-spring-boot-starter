/*
 * #%L
 * %%
 * Copyright (C) 2015 Trustsystems Desenvolvimento de Sistemas, LTDA.
 * %%
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the Trustsystems Desenvolvimento de Sistemas, LTDA. nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */
package com.github.nntk.elfinder.configuration;

import com.github.nntk.elfinder.LogosProperties;
import com.github.nntk.elfinder.configuration.jaxb.ElfinderConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Elfinder Configuration Wrapper class.
 *
 * @author Thiago Gutenberg Carvalho da Costa
 */
public class ElfinderConfigurationWrapper {

    private static final Logger log = LoggerFactory.getLogger(ElfinderConfigurationWrapper.class);

//    public static final String XML_FILE = "elfinder-configuration.xml";
//    public static final String CONF_DIR = System.getProperty("user.home") + File.separator + "elfinder" + File.separator;
//    public static final String XML_PATH = CONF_DIR + XML_FILE;

//    public static final String XML_PATH = System.getenv("ELFINDER_CONFIGURATION_XML");

    private ElfinderConfiguration elfinderConfiguration;

    private LogosProperties logosProperties;

    public ElfinderConfigurationWrapper(LogosProperties logosProperties) {
        this.logosProperties = logosProperties;
        loadElfinderConfiguration();
    }

    public ElfinderConfigurationWrapper() {
        loadElfinderConfiguration();
    }

    private void loadElfinderConfiguration() {
        if (logosProperties.getFilePath() == null) {
            throw new AssertionError(
                    "Could not load Elfinder Configuration XML file. Please verify if the ELFINDER_CONFIGURATION_XML enviroment variable is setup.");
        }


        elfinderConfiguration = new ElfinderConfiguration();
        ElfinderConfiguration.Thumbnail thumbnail = new ElfinderConfiguration.Thumbnail();
        thumbnail.setWidth(BigInteger.valueOf(80l));

        List<ElfinderConfiguration.Volume> volumeList = new ArrayList<>();

        logosProperties.getFilePath().forEach((k, v) -> {

            ElfinderConfiguration.Volume volume = new ElfinderConfiguration.Volume();
            volume.setAlias(v.get("alias"));
            volume.setLocale("zh_CH");
            volume.setPath(v.get("path"));
            volume.setSource("filesystem");
            volumeList.add(volume);
        });


        elfinderConfiguration.setThumbnail(thumbnail);
        elfinderConfiguration.setVolume(volumeList);
    }

    public Integer getThumbnailWidth() {
        int thumbnailWidth = 80; //default value
        if (elfinderConfiguration.getThumbnail() != null) {
            thumbnailWidth = elfinderConfiguration.getThumbnail().getWidth().intValue();
        }
        return thumbnailWidth;
    }

    public List<ElfinderConfiguration.Volume> getVolumes() {
        return Collections.unmodifiableList(elfinderConfiguration.getVolume());
    }
}
