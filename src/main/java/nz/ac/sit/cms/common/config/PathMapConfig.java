package nz.ac.sit.cms.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.io.File;

/**
 * @program: cms
 * @description: Map to real path.
 * @author: wangliang (Lucas Wang)
 * @email: lucas.wang.1024@gmail.com
 * @date: 2023-06-16 14:22
 **/

@Configuration
public class PathMapConfig implements WebMvcConfigurer {
    @Value("${path.mediafile}")
    private String mediaFilePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        File file = new File(mediaFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        registry.addResourceHandler("/media_file/**").addResourceLocations("file:" + mediaFilePath);
    }
}
