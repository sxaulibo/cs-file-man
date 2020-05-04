public class Camera {

    private Integer cameraId;

    private String cameraName;

    public Integer getCameraId() {
        return cameraId;
    }

    public void setCameraId(Integer cameraId) {
        this.cameraId = cameraId;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public Camera(Integer cameraId, String cameraName) {
        this.cameraId = cameraId;
        this.cameraName = cameraName;
    }

    @Override
    public String toString() {
        return cameraId +
                ":" + cameraName +"  " ;
    }
}
