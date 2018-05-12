<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <script src="/vue/vue.js"></script>
    <link rel="stylesheet" href="/css/loginForm.css">
</head>
<body>
<div id="app">
    <div :style="styless">vue测试</div>
</div>

<div id="cak" v-cloak>
    {{message}}
</div>

<div id="bol">
    <template v-if="status===1">
        <p>测试文本1</p>
        <p>测试文本2</p>
        <p>测试文本3</p>
    </template>
</div>

<div id="ipt">
    <template v-if="type==='name'">
        <label>用户名：</label>
        <input placeholder="请输入用户名">
    </template>
    <template v-else>
        <label>邮箱：</label>
        <input placeholder="请输入邮箱">
    </template>
    <button @click="toggleInputType">切换输入信息</button>
</div>

<div id="show">
    <p v-show="status===1">status为1时显示</p>
</div>

<div id="sortBook">
    <ul>
        <template v-for="book in sortBooks">
            <li>参考书名：{{book.name}}</li>
            <li>作者：{{book.author}}</li>
        </template>
    </ul>
</div>

<div id="clickEvent">
    <a href="http://www.baidu.com" @click="handleClick('禁止打开百度链接',$event)">打开百度</a>
</div>

<div id="comp">
<my-component></my-component>
</div>

<div id="contact">
    <p>总数：{{total}}</p>
    <my-contactcomponent
    @increase="handleTotal"
    @reduce="handleTotal">
    </my-contactcomponent>
</div>

<script>
    Vue.component('my-contactcomponent',{
        template:'\
        <div>\
         <button @click="handleIncrease">+1</button>\
         <button @click="handleReduce">-1</button>\
        </div>',
        data:function(){
            return {
                counter:0
            }
        },
        methods:{
            handleIncrease:function(){
                this.counter++;
                this.$emit('increase',this.counter)
            },
            handleReduce:function(){
                this.counter--;
                this.$emit('reduce',this.counter)

            }

        }
    });

    var contact=new Vue({
        el:'#contact',
        data:{
            total:0
        },
        methods:{
            handleTotal:function(total){
                this.total=total;
            }
        }

    })
</script>

<script>
    Vue.component("my-component",{
        template:'<div>{{message}}</div>',
        data:function(){
            return {
                message:'组件内容'
            }cd
        }
    });
    var comp=new Vue({
        el:'#comp'
    })
</script>

<script>
    var clickEvent=new Vue({
        el:'#clickEvent',
        methods:{

            handleClick: function(message,event){
                event.preventDefault();
                window.alert(message);

            }
        }
    })
</script>

<script>
    var app=new Vue({
            el: '#app',
            data: {
                styless: {
                    color: 'red',
                    fontSize: 15+'px'

                }
        }
    })
</script>
<script>
    var cak=new Vue({
        el: '#cak',
        data:{
            message:'一个移除的组件'
        }
    })
</script>
<script>
    var bol=new Vue({
        el:'#bol',
        data:{
            status:2
        }
    })
</script>
<script>
    var toggleInput=new Vue({
        el:'#ipt',
        data:{
            type:'name'
        },
        methods:{
            toggleInputType:function(){
                this.type=this.type==='name'? 'mail':'name';
            }
        }
    })
</script>
<script>
    var show=new Vue({
        el:'#show',
        data:{
            status:2
        }
    })
</script>

<script>
    var sortBook=new Vue({
        el:'#sortBook',
        data:{
            books:[
                {
                    name:'Vue.js实战',
                    author:'尤雨溪'
                },
                {
                    name:'JavaScript详解',
                    author:'ligang'
                },
                {
                    name:'JavaScript高级程序设计',
                    author:'HK'
                }
            ]
        },
        computed:{
            sortBooks:function(){
                return this.books.sort(function(a,b)
                {
                    return a.name.length<b.name.length;
                })
            }

        }
    })
</script>

</body>
</html>