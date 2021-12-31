package baiTapPremium.L38.b1;

import baiTapPremium.L37.B1.Personnel;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException, ParseException {

        var fileName = "E:\\FILE SAVE\\java\\JavaTutorial\\src\\baiTapPremium\\L38\\b1\\bankacount.txt";
        Scanner scanner = new Scanner(System.in);
        BankInfor bankInfor = new BankInfor();
        ArrayList<BankInfor> bankInforArrayList = new ArrayList<>();
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        bankInforArrayList.addAll(readFile(fileName));

        var chosse = 0;

        var readFILE =  readFile(fileName);
        System.out.println("\n\t========== Danh sách nhân viên hiện thời ==========");
        System.out.printf("\n\t%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
                "MÃ TK", "TÊN TK", "SỐ TK", "LOẠI TK", "NGÂN HÀNG", "SỐ DƯ", "NGÀY PH", "NGÀY HH");
        for( var i : readFILE ){
            bankInfor(i);
        }

        do{
            System.out.println("\n");
            System.out.println("\n\t ======================= MENU =======================");
            System.out.println("\t|| 1.  THÊM MỚI TÀI KHOẢN                           ||");
            System.out.println("\t|| 2.  HIỂN THỊ THÔNG TIN TÀI KHOẢN                 ||");
            System.out.println("\t|| 3.  NẠP TIỀN VÀO TÀI KHOẢN                       ||");
            System.out.println("\t|| 4.  RÚT TIỀN RA KHỎI TÀI KHOẢN                   ||");
            System.out.println("\t|| 5.  TÌM TÀI KHOẢN THEO TÊN                       ||");
            System.out.println("\t|| 6.  TÌM TÀI KHOẢN THEO MÃ                        ||");
            System.out.println("\t|| 7.  TÌM TÀI KHOẢN CÓ SỐ DƯ >= 'X';               ||");
            System.out.println("\t|| 8.  XÓA MỘT TÀI KHOẢN (theo mã)                  ||");
            System.out.println("\t|| 9.  GHI DANH SÁCH TÀI KHOẢN RA FIE               ||");
            System.out.println("\t|| 0. THOÁT CHƯƠNG TRÌNH                            ||");
            System.out.println("\t =======================================================");
            System.out.print("\t =====> XIN MỜI CHỌN   ");
            chosse = scanner.nextInt();
            scanner.nextLine();

            switch (chosse){
                case 1:{
                     var bankAcount = addBankCount(bankInforArrayList);
                     bankInforArrayList.add(bankAcount);
                    System.out.println("\n\tthem thong tin khanh hanh thanh cong !");
                    break;
                }
                case 2:{
                    if( bankInforArrayList.size() > 0 ){
                        showBankAccoutn(bankInforArrayList);
                    }else{
                        System.out.println("\n\tdanh sach khach hang rong");
                    }
                    break;
                }

                case 3:{
                    if( bankInforArrayList.size() > 0 ) {
                        System.out.print("\n\tnhap ma tk: ");
                        var id = scanner.nextLine();
                        var checkId = findAcount_Id(id, bankInforArrayList);
                        if (checkId != null) {
                            System.out.print("nhap so tien muon chuyen: ");
                            var money = scanner.nextDouble();
                            findId_addMoney(bankInforArrayList, id, money);
                            System.out.println("\n\tnap tien thanh cong");
                        } else {
                            System.out.println("\n\tma tk khong hop le");
                            break;
                        }
                    }else{
                        System.out.println("\n\tdanh sach tai khoan rong");
                    }
                    break;
                }

                case 4:{
                    if( bankInforArrayList.size() > 0 ){
                        System.out.println("\n\tnhap ma tk: ");
                        var id = scanner.nextLine();
                        var checkId = findAcount_Id(id, bankInforArrayList);
                        if( checkId != null ){
                            System.out.println("\n\tnhap so tien: ");
                            var monney = scanner.nextDouble();
                            findId_removeMoney(bankInforArrayList, id, monney);

                        }else{
                            System.out.println("\n\tdanh sach tai khoan rong");
                        }
                        }else{
                            System.out.println("\n\tma tai khoan khong hop le !");
                        }
                    break;
                }

                case 5:{
                    if( bankInforArrayList.size() > 0 ){
                        findAccountByName(bankInforArrayList);
                    }else{
                        System.out.println("\n\tdanh sach tai khoan rong");
                    }
                    break;
                }

                case 6:{
                    if( bankInforArrayList.size() > 0 ){
                        findAccountById(bankInforArrayList);
                    }else{
                        System.out.println("\n\tdanh sach tai khoan rong");
                    }
                    break;
                }

                case 7:{
                    if(bankInforArrayList.size() > 0 ){
                        findSurplus(bankInforArrayList);
                    }else{
                        System.out.println("\n\tdanh sach tai khoan rong");
                    }
                    break;
                }

                case 8:{
                    if( bankInforArrayList.size() > 0 ){
                        System.out.print("\n\tnhap ma tk can xoa:  ");
                        var id = scanner.nextLine();
                        var checkId = findAcount_Id(id, bankInforArrayList);
                        if( checkId != null ){
                            bankInforArrayList.remove(checkId);
                        System.out.println("\n\tXoa tai khoan thanh cong! ");
                        }else{
                            System.out.println("\n\tkhong tim thay tk co id " + id );
                        }
                    }else{
                        System.out.println("\n\tdanh sach khach hang rong");
                    }
                    break;
                }

                case 9:{
                    if( bankInforArrayList.size() > 0 ){
                        var writefile = writeFile(bankInforArrayList, fileName);
                        if( writefile ){
                            System.out.println("ghi file thanh cong");
                        }else{
                            System.out.println("ghi file that bai");
                        }
                    }else{
                        System.out.println("\n\tDanh sach tai khoan rong ");
                    }
                    break;
                }

                case 0:{
                    break;
                }

            }//end case

        }while( chosse != 0 );

    }//end main

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void findSurplus( ArrayList<BankInfor> bankInforArrayList ){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\tNhap so so du: ");
        var surplus = scanner.nextDouble();
        var checkSurplus = _findSurplus(bankInforArrayList, surplus);
        if( checkSurplus != null ){
            System.out.println("\n\tTim thay tk co so du >=" + surplus);
            System.out.printf("\n\t%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
                    "MÃ TK", "TÊN TK", "SỐ TK", "LOẠI TK", "NGÂN HÀNG", "SỐ DƯ", "NGÀY PH", "NGÀY HH");
            for( var i : bankInforArrayList ){
                bankInfor(i);
            }
        }else{
            System.out.println("\n\t khong tim thay tai khoan co so du >= " + surplus);
        }
    }

    private static BankInfor _findSurplus( ArrayList<BankInfor> bankInforArrayList, double surplus ){
        for( var i : bankInforArrayList ){
            if( i.getSurplus() >= surplus  ){
                return i;
            }
        }
        return null;
    }

    private static ArrayList<BankInfor> readFile(String fileName ) throws FileNotFoundException, ParseException {

        ArrayList<BankInfor> bankInforArrayList = new ArrayList<>();

        var file = new File(fileName);
        var scanner = new Scanner(file);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        while( scanner.hasNextLine() ){
            String id = scanner.nextLine();
            String acountNumber = scanner.nextLine();
            var name = scanner.nextLine();
            var type = scanner.nextLine();
            var surplus = Double.parseDouble(scanner.nextLine());
            var bankname = scanner.nextLine();
            var startDate = simpleDateFormat.parse(scanner.nextLine());
            var endDate = simpleDateFormat.parse(scanner.nextLine());

             BankInfor bankInfor = new BankInfor(id, acountNumber, name, type, surplus, bankname , startDate, endDate);
             bankInforArrayList.add(bankInfor);
        }
        scanner.close();
        return bankInforArrayList;
    }


    private static boolean findId_addMoney( ArrayList<BankInfor> bankInforArrayList, String id, double money ){
       var checkId =  findAcount_Id(id, bankInforArrayList);
       if( checkId != null ){
           return checkId.addMoneyToAcount(money);
       }else{
           return false;
       }
    }

    private static boolean findId_removeMoney( ArrayList<BankInfor> bankInforArrayList, String id, double money){
        var checkId = findAcount_Id( id, bankInforArrayList);
        if( checkId != null ){
           return checkId.removeMoneyToAccount(money);
        }
        return false;
    }

    private static void findAccountById(ArrayList<BankInfor> bankInforArrayList) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\tNhap ma tai khoan can tim: ");
        var acountId = scanner.nextLine();

        var findAc = findAcount_Id(acountId, bankInforArrayList);
        if( findAc != null ){
            System.out.println("\n\tTim thay tk co ma " + acountId);
            System.out.printf("\n\t%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
                    "MÃ TK", "TÊN TK", "SỐ TK", "LOẠI TK", "NGÂN HÀNG", "SỐ DƯ", "NGÀY PH", "NGÀY HH");
            for( var i : bankInforArrayList ){
                bankInfor(i);
            }

        }else{
            System.out.println("\n\tkhong tim thay tk");
        }

    }

    private static BankInfor findAcount_Id(String acountId, ArrayList<BankInfor> bankInforArrayList) {
        for( var i : bankInforArrayList ){
            if( i.getId().equalsIgnoreCase(acountId) ){
                return i;
            }
        }
        return null;
    }

    private static void findAccountByName(ArrayList<BankInfor> bankInforArrayList) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\tNhap ten tai khoan can tim: ");
        var acountName = scanner.nextLine();

        var findAc = findAcount_Name(acountName, bankInforArrayList);
        if( findAc != null ){
            System.out.println("\n\tTim thay tk co ten " + acountName);
            System.out.printf("\n\t%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
                    "MÃ TK", "TÊN TK", "SỐ TK", "LOẠI TK", "NGÂN HÀNG", "SỐ DƯ", "NGÀY PH", "NGÀY HH");
            for( var i : bankInforArrayList ){
                bankInfor(i);
            }

        }else{
            System.out.println("\n\tkhong tim thay tk");
        }

    }

    private static BankInfor findAcount_Name(String acountName, ArrayList<BankInfor> bankInforArrayList) {
        for( var i : bankInforArrayList ){
            if( i.getAcountName().equalsIgnoreCase(acountName) ){
                return i;
            }
        }
        return null;
    }

    private static boolean writeFile( ArrayList<BankInfor> bankInforArrayList , String fileName ){
        try {
            Scanner scanner = new Scanner( new File(fileName) );
            BankInfor bankInfor = new BankInfor();
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

//            var i = 0;
         for( int i = 0; i < bankInforArrayList.size(); i++ ){
                var emp = bankInforArrayList.get(i);
                printWriter.println(emp.getId());
                printWriter.println(emp.getAcountNumber());
                printWriter.println(emp.getAcountName());
                printWriter.println(emp.getAcountType());
                printWriter.println(emp.getSurplus());
                printWriter.println(emp.getBankName());
                printWriter.println(simpleDateFormat.format(emp.getStartDate()));
                printWriter.println(simpleDateFormat.format(emp.getEndDate()));

            }

            printWriter.close();
            fileWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    private static void showBankAccoutn(ArrayList<BankInfor> bankInforArrayList) {
        System.out.printf("\n\t%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
                "MÃ TK", "TÊN TK", "SỐ TK", "LOẠI TK", "NGÂN HÀNG", "SỐ DƯ", "NGÀY PH", "NGÀY HH");
        for( var i : bankInforArrayList ){
            bankInfor(i);
        }
    }

    private static void bankInfor( BankInfor bankInfor ){
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        System.out.printf("\n\t%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
                bankInfor.getId(), bankInfor.getAcountName(), bankInfor.getAcountNumber(), bankInfor.getAcountType(),
                bankInfor.getBankName(),bankInfor.getSurplus(), dateFormat.format(bankInfor.getStartDate()), dateFormat.format(bankInfor.getEndDate()));
    }

    private static BankInfor addBankCount(ArrayList<BankInfor> bankInforArrayList) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\tNhap ten tk: " );
        var acountName = scanner.nextLine();

        System.out.print("\n\tnhap so tk: " );
        var acountNumber = scanner.nextLine();

        System.out.print("\n\tnhap loai tk: " );
        var acountType = scanner.nextLine();

        System.out.print("\n\tnhap so du: " );
        var surplus = Long.parseLong(scanner.nextLine());

        var format = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        System.out.print("\n\tnhap ngay phat hanh (dd/MM/yyyy): ");
        Date startDate = null;
        try {
            startDate = simpleDateFormat.parse(scanner.nextLine());

            System.out.println(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.print("\n\tnhap ngay het han (dd/MM/yyyy): ");
        Date endDate = null;
        try {
            endDate = simpleDateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new BankInfor( null, acountNumber, acountName, acountType, surplus, null, startDate, endDate);
    }


}
