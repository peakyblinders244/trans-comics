package com.transcomics.transcomics.config;

import org.apache.commons.io.FilenameUtils;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Le-Hong-Quan
 * Date: 28/05/2024
 * Time: 15:16
 */
public class MultipleMessageSource extends ReloadableResourceBundleMessageSource {
    private static final String PROPERTIES_SUFFIX = ".properties";
    private final ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

    public void setFileWildCard(String basename) {
        try {
            Resource[] resources = resolver.getResources("classpath*:" + basename + "*" + PROPERTIES_SUFFIX);
            List<String> baseNames = new ArrayList<>();
            for (Resource resource : resources) {
                String file = resource.getFilename();
                String message = FilenameUtils.removeExtension(file);
                baseNames.add("classpath:" + message);
            }
            super.setBasenames(baseNames.toArray(new String[0]));
        } catch (IOException ignored) {
        }
    }
}

