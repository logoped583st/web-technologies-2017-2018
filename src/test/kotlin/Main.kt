import org.junit.runner.RunWith
import org.junit.runners.Suite

class Main {

    @RunWith(Suite::class)
    @Suite.SuiteClasses(
            ServiceTest::class
    )
    class UnitTestsSuite
}