//
window.onload = function(){
    var Words = document.getElementById("words");
    var Who = document.getElementById("who");
    var TalkWords = document.getElementById("talkwords");
    var TalkSub = document.getElementById("talksub");
    // var innerHTML = Words.innerHTML;
    Words.innerHTML = "";


    //wangEditor富文本编辑器
    var E = window.wangEditor;
    //这里的id为<div id="editor">中的id.
    var editor = new E('#emoji', '#editorText');
    // var editor1 = new E('#div1', '#div2')  // 两个参数也可以传入 elem 对象，class 选择器
    // 配置服务器端地址,也就是servlet的请求路径，不带项目路径，前面没有/
    // editor.customConfig.uploadImgServer = 'uploadFile';
    editor.customConfig.uploadImgShowBase64 = true;
    editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
    editor.customConfig.menus = [
        'emoticon' // 表情
    ];
    //监控音乐的文字，实时更新到shareText
    editor.customConfig.onchange = function (html) {
        bigBox.shareText = html;
    };
    //创建编辑器
    editor.create();

    TalkSub.onclick = function(){
        //定义空字符串
        var str = "";
        if(TalkWords.value == ""){
            // 消息为空时弹窗
            alert("消息不能为空");
            return;
        }
        if(Who.value == 0){
            //如果Who.value为0n那么是 A说
            str = '<div class="atalk"><span>A说 :' + TalkWords.value +'</span></div>';
        }
        else{
            str = '<div class="btalk"><span>B说 :' + TalkWords.value +'</span></div>' ;
        }
        Words.innerHTML = Words.innerHTML + str;
        // innerHTML = ;
    }

}

