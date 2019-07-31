package com.atguigu.springboot.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties:告诉springboot将本类中所有属性和配置文件中相关的属性绑定
 * prefix = "person":配置文件中那个下面的所有属性进行一一映射(默认从全局配置文件中获取)
 * 只要这个组件是容器的组件，才能为容器提供功能
 */

@Data
@Component
@PropertySource(value = {"classpath:person.properties"})
@ConfigurationProperties(prefix = "person")
@Validated//支持数据校验
public class Person {
    /**
     * <bean class="Person">
     *     <property name="lastName" value="字面量/${key}从环境变量、配置文件中获取值#{SpEL}"></property>
     * </bean>
     */
    //lastName必须是邮箱格式
    //@Email
    //@Value("${person.lastName}")
    private String lastName;
   // @Value("#{11*2}")
    private Integer age;
    //@Value("true")
    private boolean boss;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}
