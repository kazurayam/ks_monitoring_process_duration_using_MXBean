import java.lang.management.ManagementFactory
import java.lang.management.RuntimeMXBean

import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class JVMMonitor {
	
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean()
		long pid = bean.getPid()
		long startTime = bean.getStartTime()
		Date startDate = new Date(startTime)
		println "[before test suite] Pid: ${pid}, Start Time ${startDate}"
	}

	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean()
		long pid = bean.getPid()
		long startTime = bean.getStartTime()
		Date startDate = new Date(startTime)
		println "[before test case] Pid: ${pid}, Start Time ${startDate}"
	}

	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean()
		long pid = bean.getPid()
		long startTime = bean.getStartTime()
		Date startDate = new Date(startTime)
		println "[after test case] Pid: ${pid}, Start Time ${startDate}"
	}
	
	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean()
		long pid = bean.getPid()
		long startTime = bean.getStartTime()
		Date startDate = new Date(startTime)
		println "[after test suite] Pid: ${pid}, Start Time ${startDate}"
	}
}