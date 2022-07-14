package com.vrondakis.zap.workflow;

import com.vrondakis.zap.ZapArchive;
import com.vrondakis.zap.ZapDriverController;
import com.vrondakis.zap.ZapDriverStub;
import com.vrondakis.zap.ZapFailBuildAction;
import hudson.model.Result;
import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;


public class ClearZapAlertsStepTest extends ZapWorkflow {
    @Test
    public void testSuccessWhenZapStarted() throws Exception {
        job.setDefinition((new CpsFlowDefinition(
                "node('slave') {\n"
                + "     startZap(zapHome: '/', port: 1234, host:'123.123.123.123')\n"
                + "     clearZapAlerts()\n"
                + "}"
                , true)));

        run = job.scheduleBuild2(0).get();


        jenkinsRule.assertBuildStatus(Result.SUCCESS, run);
    }

    @Test
    public void zapFailureNoZap() throws Exception {
        // If archiveZap() is ran without call starting startZap first, it should not break the build.
        job.setDefinition(new CpsFlowDefinition(
                "node('slave') {\n"
                + "     clearZapAlerts()\n"
                + "}"
                , true));

        run = job.scheduleBuild2(0).get();
        jenkinsRule.assertBuildStatus(Result.SUCCESS, run);
    }
}