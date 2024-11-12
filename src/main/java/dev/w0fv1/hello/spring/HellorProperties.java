    package dev.w0fv1.hello.spring;

    import org.springframework.boot.context.properties.ConfigurationProperties;

    @ConfigurationProperties(prefix = "hellor")
    public class HellorProperties {

        private String content = "World"; // 默认值为 "World"

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
