import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Main {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat p = Imgcodecs.imread("D:\\Apps\\Building\\Face_Detector\\src\\JAVA.webp");
        if(p.empty()){
            System.out.println("No pic founded");
            return;
        }
            HighGui.imshow("Image", p);
        HighGui.waitKey(1000);
        System.out.println(p.cols());
        System.out.println(p.channels());
        Mat g = new Mat();
        Imgproc.cvtColor(p, g, Imgproc.COLOR_BGR2GRAY);
        HighGui.imshow("Image", g);
        HighGui.waitKey(0);
    }
}