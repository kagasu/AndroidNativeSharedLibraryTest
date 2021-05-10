import com.github.unidbg.linux.android.AndroidEmulatorBuilder;
import com.github.unidbg.linux.android.AndroidResolver;
import com.github.unidbg.linux.android.dvm.AbstractJni;
import java.io.File;

class NativeTest extends AbstractJni {
    public void callFunction(){
        var emulator = AndroidEmulatorBuilder
                .for32Bit()
                .setProcessName("com.example.hellojni")
                .build();
        var memory = emulator.getMemory();
        memory.setLibraryResolver(new AndroidResolver(19));
        var vm = emulator.createDalvikVM(null);
        vm.setJni(this);

        var library = vm.loadLibrary(new File("src/main/resources/libhelloworld.so"), false);
        library.callJNI_OnLoad(emulator);
        var result = vm
                .resolveClass("com/example/hellojni/MainActivity")
                // Java VM型のシグネチャ
                // https://docs.oracle.com/javase/jp/8/docs/technotes/guides/jni/spec/types.html
                .callStaticJniMethodObject(emulator, "helloworld(Ljava/lang/String;)");
        System.out.println(result.toString());
    }
}

public class Main extends AbstractJni {
    public static void main(String[] args){
        var nativeTest = new NativeTest();
        nativeTest.callFunction();
    }
}
