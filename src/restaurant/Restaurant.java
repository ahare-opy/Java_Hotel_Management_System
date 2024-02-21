package restaurant;

public class Restaurant {
        private  String room,code,quantity,price,code1,price1;
        private String name,BDT;

        Restaurant(){

        }

        public String getRoom() {
            return room;
        }

        public void setRoom(String room) {
            this.room = room;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCode1() {
            return code1;
        }

        public void setCode1(String code1) {
            this.code1 = code1;
        }

        public String getPrice1() {
            return price1;
        }

        public void setPrice1(String price1) {
            this.price1 = price1;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBDT() {
            return BDT;
        }

        public void setBDT(String BDT) {
            this.BDT = BDT;
        }


        public String writeFile(){
            return this.getCode()+"    "+this.getBDT()+"    "+this.getPrice()+"    "+this.getName();
        }
        public String writeFile2(){
            return this.getRoom()+"    "+this.getCode()+"    "+this.getQuantity()+"    "+this.getPrice();
        }

    }
