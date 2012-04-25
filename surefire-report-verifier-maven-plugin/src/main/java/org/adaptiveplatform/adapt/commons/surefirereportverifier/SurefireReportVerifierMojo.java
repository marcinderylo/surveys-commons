package org.adaptiveplatform.adapt.commons.surefirereportverifier;


import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.surefire.report.ReportTestSuite;
import org.apache.maven.plugins.surefire.report.SurefireReportParser;
import org.apache.maven.reporting.MavenReportException;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @goal verify
 * @phase verify
 */
public class SurefireReportVerifierMojo extends AbstractMojo {

    /**
     * Base directory from where all reports are read
     *
     * @parameter default-value="${project.build.directory}/surefire-reports"
     */
    private File reportsDirectory;

    public void execute() throws MojoExecutionException {
        SurefireReportParser report = new SurefireReportParser(Arrays.asList(reportsDirectory), Locale.getDefault());
        try {
            List<ReportTestSuite> suites = report.parseXMLReportFiles();
            for (ReportTestSuite suite : suites) {
                if (suite.getNumberOfErrors() + suite.getNumberOfFailures() > 0) {
                    throw new MojoExecutionException("There were test errors!");
                }
            }
        } catch (MavenReportException e) {
            throw new MojoExecutionException("Failed to parse report files", e);
        }
    }


}
