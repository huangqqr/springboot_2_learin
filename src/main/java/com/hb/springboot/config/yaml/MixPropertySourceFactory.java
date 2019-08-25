package com.hb.springboot.config.yaml;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.Properties;

/**
 * 引用外部配置文件
 * @PropertySource默认不支持读取yaml格式的外部配置文件
 * 所有我们要继承DefaultPropertySourceFactory,然后对他的CreatePropertySource进行如下修改
 *
 * 在对应的实体类上添加如下：
 *      @PropertySource(value = {"classpath:family.yml"}, factory = MixPropertySourceFactory.class)
 * */
public class MixPropertySourceFactory extends DefaultPropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) throws IOException {
        //return name != null ? new ResourcePropertySource(name, resource) : new ResourcePropertySource(resource);
        String sourceName = name != null ? name : resource.getResource().getFilename();
        if (!resource.getResource().exists()) {
            return new PropertiesPropertySource(sourceName, new Properties());
        } else if (sourceName.endsWith(".yml") || sourceName.endsWith(".yaml")) {
            Properties propertiesFromYaml = loadYml(resource);
            return new PropertiesPropertySource(sourceName, propertiesFromYaml);
        } else {
            return super.createPropertySource(name, resource);
        }
    }

    private Properties loadYml(EncodedResource resource) throws IOException {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }
}
