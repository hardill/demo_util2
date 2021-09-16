package com.demo.config;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouterUtil;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

//@Configuration
public class MySaTokenConfig implements WebMvcConfigurer {
    // 注册sa-token的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册路由拦截器，自定义验证规则
        registry.addInterceptor(new SaRouteInterceptor((request, response, handler) -> {

            // 登录验证 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
            //SaRouterUtil.match("/**", "/user/doLogin", () -> StpUtil.checkLogin());

            // 登录验证 -- 排除多个路径
            SaRouterUtil.match(Arrays.asList("/**"), Arrays.asList("/auth/login","/auth/logout",
                    "/v2/api-docs", "/swagger-resources/configuration/ui",
                    "/swagger-resources", "/swagger-resources/configuration/security",
                    "/swagger-ui.html/**", "/webjars/**"), () -> StpUtil.checkLogin());

            // 角色认证 -- 拦截以 admin 开头的路由，必须具备[admin]角色或者[super-admin]角色才可以通过认证
            SaRouterUtil.match("/admin/**", () -> StpUtil.checkRoleOr("admin", "super-admin"));

            // 权限认证 -- 不同模块, 校验不同权限
            SaRouterUtil.match("/user/**", () -> StpUtil.checkPermission("user"));
            SaRouterUtil.match("/admin/**", () -> StpUtil.checkPermission("admin"));
            SaRouterUtil.match("/goods/**", () -> StpUtil.checkPermission("goods"));
            SaRouterUtil.match("/orders/**", () -> StpUtil.checkPermission("orders"));
            SaRouterUtil.match("/notice/**", () -> StpUtil.checkPermission("notice"));
            SaRouterUtil.match("/comment/**", () -> StpUtil.checkPermission("comment"));

            // 匹配 restful 风格路由
            SaRouterUtil.match("/article/get/{id}", () -> StpUtil.checkPermission("article"));

            // 检查请求方式
            SaRouterUtil.match("/notice/**", () -> {
                if(request.getMethod().equals(HttpMethod.GET.toString())) {
                    StpUtil.checkPermission("notice");
                }
            });

            // 在多账号模式下，可以使用任意StpUtil进行校验
            SaRouterUtil.match("/user/**", () -> StpUtil.checkLogin());

        })).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
        // 放行swagger
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
