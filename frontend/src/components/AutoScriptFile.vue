<template>
  <div class="autoscript">
    <div class="userinfo">
       <Avatar src="../static/images/Koala.jpg" />
       <span class="username">欢迎 {{username}}</span>
    </div>
    <div class="scripttable">
      <Upload
        multiple
        :show-upload-list="false"
        :on-success="handleSuccess"
        :format="['xlsx','xls']"
        :on-format-error="handleFormatError"
        action="//www.lubo.com:8080/upload">
        <Button type="primary">上传脚本</Button>
      </Upload>
      <i-button type="ghost" class="baseurl">baseURL</i-button>
      <Input class="baseurl" v-model="baseUrl" placeholder="请输入应用基础地址" style="width: 300px"/>
      <Select class="baseurl" v-model="browser" style="width:200px">
        <Option v-for="item in browserList" :value="item.value" :key="item.value">{{ item.label }}</Option>
      </Select>
      <Table id="tab" highlight-row ref="currentRowTable" :columns="columns" :data="historyList"></Table>
      <Page id="page" :total=fileList.length :page-size=10 :current="pageNum" @on-change="changepages"></Page>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AutoScript',
  data () {
    return {
      username: localStorage.getItem('bname'),
      columns: [
        {
          type: 'index',
          width: 60,
          align: 'center'
        },
        {
          title: '文件名',
          key: 'fileName',
          width: 500
        },
        {
          title: '操作',
          key: 'handle',
          width: 200,
          render: (h, params) => {
            return h('div', [
              h('Button',
                {
                  props: {
                    type: 'ghost',
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.remove(params)
                    }
                  }
                }, '删除'),
              h('Button',
                {
                  props: {
                    type: 'ghost',
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.execute(params)
                    }
                  }
                }, '执行脚本')
            ])
          }
        }
      ],
      fileList: [],
      historyList: [],
      pageNum: 1,
      baseUrl: '',
      browser: '',
      browserList: [
        {
          value: 'chrome',
          label: 'chrome'
        },
        {
          value: 'firefox',
          label: 'firefox'
        }
      ]
    }
  },
  methods: {
    remove (params) {
      this.$Modal.confirm(
        {
          title: '提示',
          content: '确定要删除吗？',
          onOk: () => {
            this.fileList.splice(params.index, 1)
            this.$http({
              method: 'post',
              url: 'http://www.lubo.com:8080/deletefile',
              data: JSON.stringify({
                fileName: params.row.fileName
              })
            }).then(function (response) {
            })
            this.refreshWindow()
          },
          onCancel: () => {

          }
        }
      )
    },
    execute (params) {
      this.$http({
        method: 'post',
        url: 'http://www.lubo.com:8080/executefile',
        data: JSON.stringify({
          fileName: params.row.fileName,
          baseUrl: this.baseUrl,
          browser: this.browser

        })
      }).then(function (response) {
      })
    },
    handleSuccess (response, file) {
      this.refreshWindow()
    },
    handleFormatError () {
      this.$Modal.confirm(
        {
          title: '提示',
          content: '上传失败，只支持excel类型文档'
        }
      )
    },
    refreshWindow () {
      var _this = this
      this.$http({
        method: 'post',
        url: 'http://www.lubo.com:8080/upload'
      }).then(function (response) {
        var names = response.data
        _this.fileList = []
        for (var i = 0; i < names.length; i++) {
          _this.fileList.push({fileName: names[i]})
        }
        if (_this.fileList.length < 10) {
          _this.historyList = _this.fileList
        } else {
          _this.historyList = _this.fileList.slice(0, 10)
        }
      })
      this.pageNum = 1
    },
    changepages (page) {
      this.pageNum = page
      var _start = (page - 1) * 10
      var _end = page * 10
      this.historyList = this.fileList.slice(_start, _end)
    }
  },
  mounted: function () {
    this.refreshWindow()
  }
}
</script>
<style scoped>
.userinfo{
  margin-left: 1200px;
  margin-top: 1px;
}
.scripttable{
  width: 800px;
  margin-left: 300px;
  margin-top: 100px;
  text-align: left;
}
#tab{
  margin-top: 5px;
}
.ivu-table-row ivu-table-row-highlight ivu-table-row-hover td{
  background-color: pink;
}
.baseurl{
  margin-top: 10px;
}
#page{
  margin-top: 20px;
  margin-left: 600px;
  margin-bottom: 20px;
}
</style>
