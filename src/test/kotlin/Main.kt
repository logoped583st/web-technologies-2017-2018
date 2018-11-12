import org.junit.runner.RunWith
import org.junit.runners.Suite

class Main {

    @RunWith(Suite::class)
    @Suite.SuiteClasses(
            ServiceTest::class,
            ServiceTestPagination::class,
            ServiceTestSort::class,
            KontrollerTest::class
    )
    class UnitTestsSuite
}