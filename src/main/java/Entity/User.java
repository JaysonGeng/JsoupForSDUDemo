package Entity;

public class User {
    private String id; //学号
    private String xm; //姓名
    private String xb; //性别
    private String kq; //考区
    private String xsm; //学院名
    private String zym; //专业
    private String csrq; //出生日期
    private String bm; //班名
    private String rxrq; //入学日期

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getKq() {
        return kq;
    }

    public void setKq(String kq) {
        this.kq = kq;
    }

    public String getXsm() {
        return xsm;
    }

    public void setXsm(String xsm) {
        this.xsm = xsm;
    }

    public String getZym() {
        return zym;
    }

    public void setZym(String zym) {
        this.zym = zym;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getRxrq() {
        return rxrq;
    }

    public void setRxrq(String rxrq) {
        this.rxrq = rxrq;
    }

    @Override
    public String toString() {
        return
                "学号：" + id + '\n' +
                        "姓名：" + xm + '\n' +
                        "性别：" + xb + '\n' +
                        "籍贯：" + kq + '\n' +
                        "学院：" + xsm + '\n' +
                        "专业：" + zym + '\n' +
                        "生日：" + csrq + '\n' +
                        "班级：" + bm + '\n' +
                        "入学时间：" + rxrq + '\n' ;
    }

}
