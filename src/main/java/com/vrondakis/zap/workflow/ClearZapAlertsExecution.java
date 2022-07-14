package com.vrondakis.zap.workflow;

import com.vrondakis.zap.ZapDriver;
import com.vrondakis.zap.ZapDriverController;
import org.jenkinsci.plugins.workflow.steps.StepContext;

/**
 * Executor for stopZap() function in Jenkins
 */
public class ClearZapAlertsExecution extends DefaultStepExecutionImpl {
    public ClearZapAlertsExecution(StepContext context) {
        super(context);
    }

    @Override
    public boolean start() {
        listener.getLogger().println("zap: Clear Zap Alerts...");
        System.out.println("zap: Clear Zap Alerts...");

        ZapDriver zap = ZapDriverController.getZapDriver(this.run, listener.getLogger());
        try {
            zap.clearZapAlerts();
        } catch (Exception e) {
            listener.getLogger().println("zap: Failed to Clear ZAP Alerts.");
        }

        getContext().onSuccess(true);
        return true;
    }
}