import java.util.Random;


public class Car implements Runnable {
    public static int DISTANCE = 100;
    public static int STEP = 2;

//    Hướng dẫn
//    Bước 1: Tạo lớp Car implements abstract interface Runnable
//
//-       Khai báo thuộc tính name(Tên của xe đua)
//
//-       Ghi đè method run của abstract interface Runnable
//
//Bước 2: Trong method run thực hiện xử lý sau.
//
//            ①Khởi tạo điểm start(hay km ban đầu)
//
//②Khởi tạo time bắt đầu cuộc đua
//
//③Thực hiện vòng lặp Kiểm tra chừng nào còn xe chưa kết thúc quãng đường đua thì xe vẫn tiếp tục chạy
//
//    Khởi tạo vận tốc ngẫu nhiên
//    Tính khoảng cách đã đi được = khoảng cách hiện tại + vận tốc ngẫu nhiên
//    Bắt đầu vẽ quãng đường các xe chạy
//    Giải thích ý nghĩa các ký hiệu:
//
//    Ký hiệu = đánh dấu quãng đường mà xe đã đi qua
//    Ký hiệu o đánh dấu xe đang ở vị trí đó
//    Ký hiệu - đánh dấu quãng đường còn lại về đích
//    Ký hiệu | đánh dấu xuất phát và đích
//    Bước 3: Tạo lớp Main
//
//    Khởi tạo biến DISTANCE = 100 là khoảng cách quãng đường đua
//
//    Khởi tạo biến STEP = 5 bước chạy mỗi xe trên đường đua
//
//    public static int DISTANCE = 100;
//
//    public static int STEP = 2;


    // Khai báo Tên của xe
    private String name;

    public Car(String name){
        this.name = name;
    }

    @Override
    public void run(){
        // Khởi tạo điểm start(hay km ban đầu)
        int runDistance = 0;
        // Khởi tạo time bắt đầu cuộc đua
         long startTime = System.currentTimeMillis();
        // Kiểm tra chừng nào còn xe chưa kết thúc quãng đường đua thì xe vẫn tiếp tục chạy
         while (runDistance<DISTANCE){
             try{
                 // Random Speed KM/H
                 int speed =(new Random()).nextInt(20);
                 // Calculate traveled distance
                 runDistance += speed;
                 // Build result graphic
                 String log ="|";
                 int percentTravel = (runDistance * 100)/DISTANCE;
                 for (int i = 0; i < DISTANCE ; i+= STEP) {
                     if (percentTravel >= i + STEP){
                         log += "=";
                     }
                     else if(percentTravel >= i && percentTravel < i + STEP){
                         log += "o";
                     }
                     else{
                         log += "-";
                     }
                 }
                 log += "|";
                 System.out.println("Car" + this.name + ": " + log + " " + Math.min(DISTANCE, runDistance) + "KM");
                 Thread.sleep(1000);

             } catch (InterruptedException e) {
                 System.out.println("Car" + this.name + " broken...");
                 break;
             }
         }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
    }

