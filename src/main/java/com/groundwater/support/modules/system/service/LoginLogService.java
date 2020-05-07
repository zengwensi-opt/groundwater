package com.groundwater.support.modules.system.service;

import com.groundwater.support.modules.system.domain.LoginLog;
import com.baomidou.mybatisplus.extension.service.IService;

public interface LoginLogService extends IService<LoginLog> {

    void saveLoginLog (LoginLog loginLog);
}
