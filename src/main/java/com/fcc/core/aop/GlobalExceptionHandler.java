package com.fcc.core.aop;

import com.fcc.common.constant.tip.ErrorTip;
import com.fcc.common.exception.BizExceptionEnum;
import com.fcc.common.exception.BussinessException;
import com.fcc.common.exception.InvalidKaptchaException;
import com.fcc.common.exception.InvalidSMSCodeException;
import com.fcc.core.log.LogManager;
import com.fcc.core.shiro.ShiroKit;
import com.fcc.core.support.HttpKit;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.UnknownSessionException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @author liupeng
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger log = Logger.getLogger(this.getClass());

    /**
     * 业务异常处理
     * @param e 业务异常
     * @return 错误信息
     */
    @ExceptionHandler(BussinessException.class)
    @ResponseBody
    public ErrorTip notFount(BussinessException e) {
//        LogManager.me().executeLog(LogTaskFactory.exceptionLog(ShiroKit.getUser().getId(), e));
        HttpKit.getRequest().setAttribute("tip", e.getMessage());
        log.error("业务异常:", e);
        return new ErrorTip(e.getCode(), e.getMessage());
    }

    /**
     * 用户未登录
     * @param e 用户认证错误
     * @return 错误信息
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public ErrorTip unAuth(AuthenticationException e) {
        log.error("用户未登陆：", e);
        return new ErrorTip(BizExceptionEnum.USER_NOT_LOGIN);
    }

    /**
     * 账号被冻结
     * @param e 账号冻结异常
     * @return 错误信息
     */
    @ExceptionHandler(DisabledAccountException.class)
    @ResponseBody
    public ErrorTip accountLocked(DisabledAccountException e) {
        String username = HttpKit.getRequest().getParameter("username");
//        LogManager.me().executeLog(LogTaskFactory.loginLog(username, "账号被冻结", HttpKit.getIp()));

        return new ErrorTip(BizExceptionEnum.ACCOUNT_FREEZED);
    }

    /**
     * 账号密码错误
     * @param e 用户名密码认证错误
     * @return 错误信息
     */
    @ExceptionHandler(CredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorTip credentials(CredentialsException e) {
        String username = HttpKit.getRequest().getParameter("phoneNumber");
        String msg = "账号密码错误";
//        LogManager.me().executeLog(LogTaskFactory.loginLog(username, msg, HttpKit.getIp()));
        return new ErrorTip(BizExceptionEnum.PWD_NOT_RIGHT);
    }

    /**
     * 数字解析错误
     * @param e 数据解析异常
     * @return 错误信息
     */
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public ErrorTip numberFormatException(NumberFormatException e){
        String username = HttpKit.getRequest().getParameter("phoneNumber");
        String msg = "数字格式错误";
//        LogManager.me().executeLog(LogTaskFactory.loginLog(username, msg, HttpKit.getIp()));
        return new ErrorTip(BizExceptionEnum.NUMBER_FORMAT_ERROR);
    }

    /**
     * 无法访问该资源
     * @param e 无法访问资源异常
     * @return 错误信息
     */
    @ExceptionHandler(UndeclaredThrowableException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorTip credentials(UndeclaredThrowableException e) {
        HttpKit.getRequest().setAttribute("tip", "权限异常");
        log.error("权限异常!", e);
        return new ErrorTip(BizExceptionEnum.NO_PERMITION);
    }

    /**
     * 拦截未知异常
     * @param e 未知异常
     * @return 错误信息
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorTip notFount(RuntimeException e) {
//        LogManager.me().executeLog(LogTaskFactory.exceptionLog(ShiroKit.getUser().getId(), e));
        HttpKit.getRequest().setAttribute("tip", "服务器运行时异常");
        log.error("运行时异常:", e);
        return new ErrorTip(BizExceptionEnum.SERVER_ERROR);
    }

    /**
     * 图片验证码错误
     * @param e 验证码错误异常
     * @return 错误信息
     */
    @ExceptionHandler(InvalidKaptchaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorTip invalidKaptcha(InvalidKaptchaException e){
//        LogManager.me().executeLog(LogTaskFactory.exceptionLog(ShiroKit.getUser().getId(), e));
        return new ErrorTip(BizExceptionEnum.INVALID_KAPTCHA.getCode(),BizExceptionEnum.INVALID_KAPTCHA.getMessage());

    }

    @ExceptionHandler(InvalidSMSCodeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorTip invalidSMSCode(InvalidSMSCodeException e){
        return new ErrorTip(BizExceptionEnum.INVID_SMS_CODE.getCode(),BizExceptionEnum.INVID_SMS_CODE.getMessage());
    }

    /**
     * session实效的异常拦截
     * @param e 错误信息
     * @param model model
     * @param request 请求
     * @param response 响应
     * @return 错误信息
     */
    @ExceptionHandler(InvalidSessionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String sessionTimeout(InvalidSessionException e, Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("tips", "session超时");
        assertAjax(request, response);
        return "/login.html";
    }

    /**
     * session异常
     * @param e 错误信息
     * @param model model
     * @param request 请求
     * @param response 响应
     * @return 错误信息
     */
    @ExceptionHandler(UnknownSessionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String sessionTimeout(UnknownSessionException e, Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("tips", "session超时");
        assertAjax(request, response);
        return "/login.html";
    }

    private void assertAjax(HttpServletRequest request, HttpServletResponse response) {
        if (request.getHeader("x-requested-with") != null
                && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
            //如果是ajax请求响应头会有，x-requested-with
            response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
        }
    }
}
