package com.vrondakis.zap.workflow;


import org.jenkinsci.plugins.workflow.steps.Step;
import org.jenkinsci.plugins.workflow.steps.StepContext;
import org.jenkinsci.plugins.workflow.steps.StepExecution;

import java.io.IOException;
import java.io.Serializable;

public class ClearZapAlertsStep extends Step implements Serializable {
    /**
     * Stop (shutdown) the zap instance.
     */
    @org.kohsuke.stapler.DataBoundConstructor
    public ClearZapAlertsStep() {}

    @Override
    public StepExecution start(StepContext context) throws IOException, InterruptedException {
        return new ClearZapAlertsExecution(context);
    }

    @hudson.Extension
    public static class DescriptorImpl extends DefaultStepDescriptorImpl<ClearZapAlertsExecution> {
        public DescriptorImpl() {
            super(ClearZapAlertsExecution.class, "clearZapAlerts", "Clear the ZAP Alerts fro Session.");
        }
    }
}