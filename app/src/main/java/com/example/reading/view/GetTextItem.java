package com.example.reading.view;

/**
 * 作者：sleepingfishboy
 * 时间：2023/1/29
 */
public class GetTextItem {


    /**
     * ret : 0
     * msg : 请求成功
     * data : {"id":9787020024759,"name":"围城","subname":null,"author":"钱锺书","translator":null,"publishing":"人民文学出版社","published":"1991-2","designed":"平装","code":"9787020024759","douban":1008145,"doubanScore":89,"brand":null,"weight":null,"size":null,"pages":"359","photoUrl":"https://img2.doubanio.com/view/subject/m/public/s1070222.jpg","localPhotoUrl":"","price":"19.00","froms":"","num":0,"createTime":"2021-04-23T15:41:56","uptime":"2021-08-03T06:00:08","authorIntro":"钱钟书(1910－1998)，字哲良，默存，号槐聚，中国江苏无锡人，中国近代著名作家、 文学研究家。毕业于清华大学外文系，获文学学士，赴上海，到光华大学任教。后考取第三届(1935年)庚子赔款公费留学资格，名列榜首，留学英国牛津大学 埃克塞特学院。大学毕业后任教于多所高校。新中国成立后被评为一级教授。晚年就职于中国社会科学院，任副院长。其夫人杨绛也是著名作家，育有一女钱媛(1937年-1997年)。曾为《毛泽东选集》英文版翻译小组成员。1998年逝世，享年88岁。","description":"《围城》是钱钟书所著的长篇小说。第一版于1947年由上海晨光出版公司出版。1949年之后，由于政治等方面的原因，本书长期无法在中国大陆和台湾重印，仅在香港出现过盗印本。1980年由作者重新修订之后，在中国大陆地区由人民文学出版社刊印。此后作者又曾小幅修改过几次。《围城》 自从出版以来，就受到许多人的推崇。由于1949年后长期无法重印，这本书逐渐淡出人们的视野。1960年代，旅美汉学家夏志清在《中国现代小说史》(A History of Modern Chinese Fiction)中对本书作出很高的评价，这才重新引起人们对它的关注。人们对它的评价一般集中在两方面，幽默的语言和对生活深刻的观察。从1990年代开始，也有人提出对本书的不同看法，认为这是一部被\u201c拔高\u201d的小说，并不是一部出色的作品。很多人认为这是一部幽默作品。除了各具特色的人物语言之外，作者夹叙其间的文字也显着机智与幽默。这是本书的一大特色。也有人认为这是作者卖弄文字，语言显得尖酸刻薄。但这一说法并不为大多数人接受。"}
     */

    private int ret;
    private String msg;
    private DataBean data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 9787020024759
         * name : 围城
         * subname : null
         * author : 钱锺书
         * translator : null
         * publishing : 人民文学出版社
         * published : 1991-2
         * designed : 平装
         * code : 9787020024759
         * douban : 1008145
         * doubanScore : 89
         * brand : null
         * weight : null
         * size : null
         * pages : 359
         * photoUrl : https://img2.doubanio.com/view/subject/m/public/s1070222.jpg
         * localPhotoUrl :
         * price : 19.00
         * froms :
         * num : 0
         * createTime : 2021-04-23T15:41:56
         * uptime : 2021-08-03T06:00:08
         * authorIntro : 钱钟书(1910－1998)，字哲良，默存，号槐聚，中国江苏无锡人，中国近代著名作家、 文学研究家。毕业于清华大学外文系，获文学学士，赴上海，到光华大学任教。后考取第三届(1935年)庚子赔款公费留学资格，名列榜首，留学英国牛津大学 埃克塞特学院。大学毕业后任教于多所高校。新中国成立后被评为一级教授。晚年就职于中国社会科学院，任副院长。其夫人杨绛也是著名作家，育有一女钱媛(1937年-1997年)。曾为《毛泽东选集》英文版翻译小组成员。1998年逝世，享年88岁。
         * description : 《围城》是钱钟书所著的长篇小说。第一版于1947年由上海晨光出版公司出版。1949年之后，由于政治等方面的原因，本书长期无法在中国大陆和台湾重印，仅在香港出现过盗印本。1980年由作者重新修订之后，在中国大陆地区由人民文学出版社刊印。此后作者又曾小幅修改过几次。《围城》 自从出版以来，就受到许多人的推崇。由于1949年后长期无法重印，这本书逐渐淡出人们的视野。1960年代，旅美汉学家夏志清在《中国现代小说史》(A History of Modern Chinese Fiction)中对本书作出很高的评价，这才重新引起人们对它的关注。人们对它的评价一般集中在两方面，幽默的语言和对生活深刻的观察。从1990年代开始，也有人提出对本书的不同看法，认为这是一部被“拔高”的小说，并不是一部出色的作品。很多人认为这是一部幽默作品。除了各具特色的人物语言之外，作者夹叙其间的文字也显着机智与幽默。这是本书的一大特色。也有人认为这是作者卖弄文字，语言显得尖酸刻薄。但这一说法并不为大多数人接受。
         */

        private long id;
        private String name;
        private Object subname;
        private String author;
        private Object translator;
        private String publishing;
        private String published;
        private String designed;
        private String code;
        private int douban;
        private int doubanScore;
        private Object brand;
        private Object weight;
        private Object size;
        private String pages;
        private String photoUrl;
        private String localPhotoUrl;
        private String price;
        private String froms;
        private int num;
        private String createTime;
        private String uptime;
        private String authorIntro;
        private String description;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getSubname() {
            return subname;
        }

        public void setSubname(Object subname) {
            this.subname = subname;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Object getTranslator() {
            return translator;
        }

        public void setTranslator(Object translator) {
            this.translator = translator;
        }

        public String getPublishing() {
            return publishing;
        }

        public void setPublishing(String publishing) {
            this.publishing = publishing;
        }

        public String getPublished() {
            return published;
        }

        public void setPublished(String published) {
            this.published = published;
        }

        public String getDesigned() {
            return designed;
        }

        public void setDesigned(String designed) {
            this.designed = designed;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getDouban() {
            return douban;
        }

        public void setDouban(int douban) {
            this.douban = douban;
        }

        public int getDoubanScore() {
            return doubanScore;
        }

        public void setDoubanScore(int doubanScore) {
            this.doubanScore = doubanScore;
        }

        public Object getBrand() {
            return brand;
        }

        public void setBrand(Object brand) {
            this.brand = brand;
        }

        public Object getWeight() {
            return weight;
        }

        public void setWeight(Object weight) {
            this.weight = weight;
        }

        public Object getSize() {
            return size;
        }

        public void setSize(Object size) {
            this.size = size;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
        }

        public String getLocalPhotoUrl() {
            return localPhotoUrl;
        }

        public void setLocalPhotoUrl(String localPhotoUrl) {
            this.localPhotoUrl = localPhotoUrl;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getFroms() {
            return froms;
        }

        public void setFroms(String froms) {
            this.froms = froms;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUptime() {
            return uptime;
        }

        public void setUptime(String uptime) {
            this.uptime = uptime;
        }

        public String getAuthorIntro() {
            return authorIntro;
        }

        public void setAuthorIntro(String authorIntro) {
            this.authorIntro = authorIntro;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
