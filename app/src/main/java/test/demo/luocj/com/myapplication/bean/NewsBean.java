package test.demo.luocj.com.myapplication.bean;

import java.util.List;

/**
 * Created by luocj515 on 2017/7/12.
 * 项目名称：MyTestDemo
 * 类描述：
 * 创建人：hasee
 * 创建时间：2017/7/12 22:56
 * 修改备注：
 */

public class NewsBean extends BaseBean {

    private List<NewslistBean> newslist;

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "newslist=" + newslist +
                '}';
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2017-06-07 10:12
         * title : 舍不得媳妇套不住流氓！警察带女友约会“钓色魔”
         * description : 搜狐社会
         * picUrl :
         * url : http://news.sohu.com/20170607/n495984947.shtml
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "NewslistBean{" +
                    "ctime='" + ctime + '\'' +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", picUrl='" + picUrl + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
