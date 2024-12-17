import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

public class Main {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture camera = new VideoCapture(0);
        CascadeClassifier faceDetector = new CascadeClassifier("haarcascade_frontalface_default.xml");
        Mat f = new Mat();
        if(!camera.isOpened()){
            System.out.println("no Camera");
            return;
        }
        while(true){
            camera.read(f);
            if(f.empty()){
                break;
            }
            MatOfRect faceR = new MatOfRect();
            faceDetector.detectMultiScale(f, faceR);
        for(Rect rect : faceR.toArray()) {
            Imgproc.rectangle(f, new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0), 3);
        }
        HighGui.imshow("face", f);
        HighGui.waitKey(0);
        }
        camera.release();
    }
}