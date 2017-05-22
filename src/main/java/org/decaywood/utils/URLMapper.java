package org.decaywood.utils;

/**
 * @author: decaywood
 * @date: 2015/11/24 18:54
 */
public enum URLMapper {

    /*--------------------------------  Xue Qiu     --------------------------------------*/

    MAIN_PAGE("https://xueqiu.com"),
    COMPREHENSIVE_PAGE("https://xueqiu.com/hq"),

    HU_SHEN_NEWS_REF_JSON("https://xueqiu.com/statuses/topic.json"),
    STOCK_SHAREHOLDERS_JSON("https://xueqiu.com/stock/f10/shareholdernum.json"),
    STOCK_SELECTOR_JSON("https://xueqiu.com/stock/screener/screen.json"),
    LONGHUBANG_JSON("https://xueqiu.com/stock/f10/bizunittrdinfo.json"),
    STOCK_INDUSTRY_JSON("https://xueqiu.com/stock/f10/compinfo.json"),
<<<<<<< HEAD
    CUBE_REBALANCING_JSON("https://xueqiu.com/cubes/rebalancing/history.json"),
    CUBE_TREND_JSON("https://xueqiu.com/cubes/nav_daily/all.json"),
=======
    CUBE_REBALANCING_JSON("https://xueqiu.com/cubes/rebalancing/history.json"),//tiao cang solve
    CUBE_TREND_JSON("https://xueqiu.com/cubes/nav_daily/all.json"),
//    CUBES_RANK_JSON("http://xueqiu.com/cubes/discover/rank/cube/list.json"),
>>>>>>> dev
    CUBES_RANK_JSON("https://xueqiu.com/cubes/discover/rank/cube/list.json"),
    MARKET_QUOTATIONS_RANK_JSON("https://xueqiu.com/stock/quote_order.json"),
    SCOPE_STOCK_RANK_JSON("https://xueqiu.com/stock/rank.json"),
    STOCK_TREND_JSON("https://xueqiu.com/stock/forchartk/stocklist.json"),
    STOCK_JSON("https://xueqiu.com/v4/stock/quote.json"),
    INDUSTRY_JSON("https://xueqiu.com/industry/quote_order.json"),

    /*--------------------------------  NetEase     --------------------------------------*/

    NETEASE_MAIN_PAGE("https://quotes.money.163.com/stock"),
    STOCK_CAPITAL_FLOW("https://quotes.money.163.com/service/zjlx_chart.html");


    URLMapper(String URL) {
        this.URL = URL;
    }

    private String URL;

    @Override
    public String toString() {
        return URL;
    }



    private String refer = "ttps://xueqiu.com/stock/screener/screen.json?category=SH&exchange=&areacode=&indcode=&" +
            "orderby=symbol&order=desc&current=ALL&pct=ALL&page=1&pb=0_5&pettm=0_50&roediluted.20170331=0_100&_=1495424651869";

    private String top = "http://xueqiu.com/cubes/discover/rank/cube/list.json?category=SH&market=cn&count=10&profit=monthly_gain";
}
