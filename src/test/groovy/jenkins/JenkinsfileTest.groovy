package jenkins

import com.lesfurets.jenkins.unit.BasePipelineTest
import com.lesfurets.jenkins.unit.global.lib.GitSource
import org.junit.Before
import org.junit.BeforeClass
import org.junit.ClassRule
import org.junit.Ignore
import org.junit.Test
import org.junit.rules.TemporaryFolder

import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library

class JenkinsfileTest extends BasePipelineTest {

    @ClassRule
    public static TemporaryFolder folder = new TemporaryFolder()

    static File temp

    @BeforeClass
    static void init() {
        temp = folder.newFolder('libs')
    }

    @Before
    void setup() {

        super.setUp()

        def library = library().name('reference-steps')
                .defaultVersion("master")
                .allowOverride(true)
                .targetPath(temp.path)
                .retriever(GitSource.gitSource("https://github.com/benemon/jenkins-example-library.git"))
                .build()

        helper.registerSharedLibrary(library)
    }


    @Test
    @Ignore("JenkinsPipelineUnit doesn't support declarative syntax yet")
    void should_return_true() {

        loadScript("pipeline.jenkins")

        printCallStack()
    }

}
