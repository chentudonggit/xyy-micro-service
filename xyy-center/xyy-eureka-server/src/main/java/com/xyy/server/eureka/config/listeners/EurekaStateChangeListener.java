package com.xyy.server.eureka.config.listeners;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * EurekaStateChangeListener
 *
 * @author chentudong
 * @date 2019/9/14 20:16
 * @since 1.0
 */
@Component
public class EurekaStateChangeListener
{
    @EventListener
    public void listen(EurekaInstanceCanceledEvent event)
    {
        System.err.println(event.getServerId() + "\t" + event.getAppName() + " 服务下线");
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event)
    {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.err.println(instanceInfo.getAppName() + "进行注册");
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event)
    {
        System.err.println(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约");
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event)
    {
        System.err.println("start- 注册中心 启动 -start");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event)
    {
        System.err.println("status- Eureka Server 启动 -status");
    }

}
