import java.util.Scanner;


class BanDoc {
    private static int nextID = 10001;
    private int maBanDoc;
    private String hoTen;
    private String diaChi;
    private String soDienThoai;
    private String loaiBanDoc;

    public BanDoc(String hoTen, String diaChi, String soDienThoai, String loaiBanDoc) {
        this.maBanDoc = nextID++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.loaiBanDoc = loaiBanDoc;
    }

    public int getMaBanDoc() {
        return maBanDoc;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getLoaiBanDoc() {
        return loaiBanDoc;
    }

    @Override
    public String toString() {
        return "Mã bạn đọc: " + maBanDoc + ", Họ tên: " + hoTen + ", Địa chỉ: " + diaChi + ", SĐT: " + soDienThoai + ", Loại bạn đọc: " + loaiBanDoc;
    }
}


class Sach {
    private static int nextID = 10001;
    private int maSach;
    private String tenSach;
    private String tacGia;
    private String chuyenNganh;
    private int namXuatBan;

    public Sach(String tenSach, String tacGia, String chuyenNganh, int namXuatBan) {
        this.maSach = nextID++;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.namXuatBan = namXuatBan;
    }

    public int getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    @Override
    public String toString() {
        return "Mã sách: " + maSach + ", Tên sách: " + tenSach + ", Tác giả: " + tacGia + ", Chuyên ngành: " + chuyenNganh + ", Năm xuất bản: " + namXuatBan;
    }
}


class QLMuonSach {
    private BanDoc banDoc;
    private Sach[] sachMuon;
    private int[] soLuongMuon;
    private int soLuongSachMuon;

    public QLMuonSach(BanDoc banDoc) {
        this.banDoc = banDoc;
        sachMuon = new Sach[5];
        soLuongMuon = new int[5];
        soLuongSachMuon = 0;
    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public void muonSach(Sach sach, int soLuong) {
        if (soLuongSachMuon < 5) {
            sachMuon[soLuongSachMuon] = sach;
            soLuongMuon[soLuongSachMuon] = soLuong;
            soLuongSachMuon++;
            System.out.println("Đã mượn sách: " + sach.getTenSach() + " (" + soLuong + " cuốn)");
        } else {
            System.out.println("Không thể mượn thêm sách, đã đạt số lượng tối đa.");
        }
    }

    public void inDanhSachMuon() {
        System.out.println("Danh sách mượn sách của " + banDoc.getHoTen() + ":");
        for (int i = 0; i < soLuongSachMuon; i++) {
            System.out.println(sachMuon[i].toString() + " - Số lượng mượn: " + soLuongMuon[i]);
        }
    }
}

public class QLTV {
    private static BanDoc[] danhSachBanDoc = new BanDoc[100];
    private static Sach[] danhSachSach = new Sach[100];
    private static QLMuonSach[] danhSachMuonSach = new QLMuonSach[100];
    private static int soLuongBanDoc = 0;
    private static int soLuongSach = 0;
    private static int soLuongMuonSach = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Nhập danh sách đầu sách mới");
            System.out.println("2. Nhập danh sách bạn đọc mới");
            System.out.println("3. Lập bảng QL mượn sách cho từng bạn đọc");
            System.out.println("4. Sắp xếp danh sách Quản lý mượn sách");
            System.out.println("5. Tìm kiếm và hiển thị danh sách mượn sách theo tên bạn đọc");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    nhapDanhSachSach();
                    break;
                case 2:
                    nhapDanhSachBanDoc();
                    break;
                case 3:
                    lapBangMuonSach();
                    break;
                case 4:
                    sapXepQLMuonSach();
                    break;
                case 5:
                    timKiemVaHienThi();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (choice != 0);
    }

    private static void nhapDanhSachSach() {
        System.out.print("Nhập số lượng sách cần thêm: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i + 1) + ":");
            System.out.print("Tên sách: ");
            String tenSach = scanner.nextLine();
            System.out.print("Tác giả: ");
            String tacGia = scanner.nextLine();
            System.out.print("Chuyên ngành: ");
            String chuyenNganh = scanner.nextLine();
            System.out.print("Năm xuất bản: ");
            int namXuatBan = scanner.nextInt();
            scanner.nextLine();

            danhSachSach[soLuongSach++] = new Sach(tenSach, tacGia, chuyenNganh, namXuatBan);
        }

        System.out.println("Danh sách sách đã có:");
        for (int i = 0; i < soLuongSach; i++) {
            System.out.println(danhSachSach[i].toString());
        }
    }

    private static void nhapDanhSachBanDoc() {
        System.out.print("Nhập số lượng bạn đọc cần thêm: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin bạn đọc thứ " + (i + 1) + ":");
            System.out.print("Họ và tên: ");
            String hoTen = scanner.nextLine();
            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();
            System.out.print("Số điện thoại: ");
            String soDienThoai = scanner.nextLine();
            System.out.print("Loại bạn đọc (sinh viên, học viên cao học, giáo viên): ");
            String loaiBanDoc = scanner.nextLine();

            danhSachBanDoc[soLuongBanDoc++] = new BanDoc(hoTen, diaChi, soDienThoai, loaiBanDoc);
        }

        System.out.println("Danh sách bạn đọc đã có:");
        for (int i = 0; i < soLuongBanDoc; i++) {
            System.out.println(danhSachBanDoc[i].toString());
        }
    }

    private static void lapBangMuonSach() {
        System.out.print("Nhập mã bạn đọc: ");
        int maBanDoc = scanner.nextInt();
        scanner.nextLine();


        BanDoc banDoc = null;
        for (int i = 0; i < soLuongBanDoc; i++) {
            if (danhSachBanDoc[i].getMaBanDoc() == maBanDoc) {
                banDoc = danhSachBanDoc[i];
                break;
            }
        }

        if (banDoc == null) {
            System.out.println("Không tìm thấy bạn đọc với mã số " + maBanDoc);
            return;
        }


        QLMuonSach qlMuonSach = new QLMuonSach(banDoc);


        char tiepTuc;
        do {
            System.out.print("Nhập mã sách: ");
            int maSach = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng newline
            // Tìm sách trong danh sách
            Sach sach = null;
            for (int i = 0; i < soLuongSach; i++) {
                if (danhSachSach[i].getMaSach() == maSach) {
                    sach = danhSachSach[i];
                    break;
                }
            }

            if (sach == null) {
                System.out.println("Không tìm thấy sách với mã số " + maSach);
            } else {
                System.out.print("Nhập số lượng mượn: ");
                int soLuong = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng newline
                qlMuonSach.muonSach(sach, soLuong);
            }

            System.out.print("Tiếp tục mượn sách? (C/K): ");
            tiepTuc = scanner.nextLine().charAt(0);
        } while (tiepTuc == 'C' || tiepTuc == 'c');


        danhSachMuonSach[soLuongMuonSach++] = qlMuonSach;
    }

    private static void sapXepQLMuonSach() {

        for (int i = 0; i < soLuongMuonSach - 1; i++) {
            for (int j = i + 1; j < soLuongMuonSach; j++) {
                if (danhSachMuonSach[i].getBanDoc().getHoTen().compareTo(danhSachMuonSach[j].getBanDoc().getHoTen()) > 0) {
                    QLMuonSach temp = danhSachMuonSach[i];
                    danhSachMuonSach[i] = danhSachMuonSach[j];
                    danhSachMuonSach[j] = temp;
                }
            }
        }

        System.out.println("Danh sách quản lý mượn sách sau khi sắp xếp theo tên bạn đọc:");
        for (int i = 0; i < soLuongMuonSach; i++) {
            System.out.println("Tên bạn đọc: " + danhSachMuonSach[i].getBanDoc().getHoTen());
            danhSachMuonSach[i].inDanhSachMuon();
            System.out.println();
        }
    }

    private static void timKiemVaHienThi() {
        System.out.print("Nhập tên bạn đọc cần tìm: ");
        String tenBanDocCanTim = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < soLuongMuonSach; i++) {
            if (danhSachMuonSach[i].getBanDoc().getHoTen().equalsIgnoreCase(tenBanDocCanTim)) {
                System.out.println("Danh sách mượn sách của bạn đọc " + tenBanDocCanTim + ":");
                danhSachMuonSach[i].inDanhSachMuon();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy thông tin của bạn đọc " + tenBanDocCanTim);
        }
    }
}
