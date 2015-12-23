/* 
* @Author: anchen
* @Date:   2015-12-17 23:13:31
* @Last Modified by:   anchen
* @Last Modified time: 2015-12-21 19:40:51
*/
var ajax = function (config) {
    var xhr = new XMLHttpRequest(),
        url = config.url,
        method = config.method || 'get',
        async = typeof config.async !== 'undefined' ? false : true,
        data = config.data,
        success = config.success;

    if (async && success) {
        xhr.addEventListener('readystatechange', function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                success(xhr.responseText);
            }
        });
    }
    if (method === 'get') {
        url = url + (data ? '?' + data : '');
        data = null;
    }
    xhr.open(method, url, async);
    if (method === 'post') {
        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    }

    xhr.send(data);
    if (!async) {
        return xhr.responseText;
    }
}

//使用方式1：直接返回值形式，关键要设置async: false
var res = ajax({
    url: url,
    data: 'url=' + encodeURIComponent(location.href),
    async: false
});
//如果res是文本类型就直接使用
resObj = res;
//如果res是json格式的字符串则需要转换
resObj = JSON.parse(res);

//使用方法2：callback方法返回值形式
var getData = function (callback) {
    ajax({
        url: url,
        success: function (res) {
            callback(JSON.parse(res));
        }
    });
}