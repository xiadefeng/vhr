(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-32db800e"],{"58da":function(e,t,i){"use strict";i.r(t);var a=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",[i("div",[i("div",{staticStyle:{display:"flex","justify-content":"space-between"}},[i("div",[i("el-input",{staticStyle:{width:"350px","margin-right":"15px"},attrs:{placeholder:"通过员工姓名搜索员工，可以直接回车搜索...",size:"small",clearable:"",disabled:e.showAdvanceSearchView,"prefix-icon":"el-icon-search"},on:{clear:e.initEmps},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.initEmps(t)}},model:{value:e.keyword,callback:function(t){e.keyword=t},expression:"keyword"}}),i("el-button",{attrs:{size:"small",type:"primary",icon:"el-icon-search",disabled:e.showAdvanceSearchView},on:{click:e.initEmps}},[e._v("搜索 ")]),i("el-button",{attrs:{size:"small",type:"primary"},on:{click:function(t){e.showAdvanceSearchView=!e.showAdvanceSearchView}}},[i("i",{class:e.showAdvanceSearchView?"fa fa-angle-double-up":"fa fa-angle-double-down",attrs:{"aria-hidden":"true"}}),e._v(" 高级搜索 ")])],1),i("div",[i("el-upload",{staticStyle:{display:"inline-flex","margin-right":"10px"},attrs:{"show-file-list":!1,"before-upload":e.beforeUpload,"on-success":e.onSuccess,"on-error":e.onError,disabled:e.importDisabled,action:"/employee/basic/import"}},[i("el-button",{attrs:{size:"small",disabled:e.importDisabled,type:"success",icon:e.importDataIcon}},[e._v(" "+e._s(e.importDataText)+" ")])],1),i("el-button",{attrs:{size:"small",type:"success",icon:"el-icon-download"},on:{click:function(t){return e.exportData("advanced")}}},[e._v(" 导出数据 ")]),i("el-button",{attrs:{size:"small",type:"primary",icon:"el-icon-plus"},on:{click:e.showAddEmpView}},[e._v("添加用户")])],1)]),i("transition",{attrs:{name:"slide-fade"}},[i("div",{directives:[{name:"show",rawName:"v-show",value:e.showAdvanceSearchView,expression:"showAdvanceSearchView"}],staticStyle:{border:"1px solid #2b9fff","border-radius":"5px","box-sizing":"border-box",padding:"5px 25px",margin:"10px 0px"}},[i("el-row",[i("el-col",{attrs:{span:5}},[e._v(" 政治面貌： "),i("el-select",{staticStyle:{width:"130px"},attrs:{size:"mini",placeholder:"政治面貌"},model:{value:e.searchValue.politicId,callback:function(t){e.$set(e.searchValue,"politicId",t)},expression:"searchValue.politicId"}},e._l(e.politicsstatus,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1),i("el-col",{attrs:{span:4}},[e._v(" 民族： "),i("el-select",{staticStyle:{width:"130px"},attrs:{size:"mini",placeholder:"请选择民族"},model:{value:e.searchValue.nationId,callback:function(t){e.$set(e.searchValue,"nationId",t)},expression:"searchValue.nationId"}},e._l(e.nations,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1),i("el-col",{attrs:{span:4}},[e._v(" 职位： "),i("el-select",{staticStyle:{width:"130px"},attrs:{size:"mini",placeholder:"请选择职位"},model:{value:e.searchValue.posId,callback:function(t){e.$set(e.searchValue,"posId",t)},expression:"searchValue.posId"}},e._l(e.positions,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1),i("el-col",{attrs:{span:4}},[e._v(" 职称： "),i("el-select",{staticStyle:{width:"130px"},attrs:{size:"mini",placeholder:"请选择职称"},model:{value:e.searchValue.jobLevelId,callback:function(t){e.$set(e.searchValue,"jobLevelId",t)},expression:"searchValue.jobLevelId"}},e._l(e.joblevels,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1),i("el-col",{attrs:{span:6,offset:1}},[e._v(" 聘用形式： "),i("el-radio-group",{model:{value:e.searchValue.engageForm,callback:function(t){e.$set(e.searchValue,"engageForm",t)},expression:"searchValue.engageForm"}},[i("el-radio",{attrs:{label:"劳动合同"}},[e._v("劳动合同")]),i("el-radio",{staticStyle:{"margin-left":"-10px"},attrs:{label:"劳务合同"}},[e._v("劳务合同")])],1)],1)],1),i("el-row",[i("el-col",{attrs:{span:5}},[e._v(" 所属部门： "),i("el-popover",{attrs:{placement:"right",title:"请选择部门",width:"200",trigger:"manual"},model:{value:e.visible,callback:function(t){e.visible=t},expression:"visible"}},[i("el-tree",{attrs:{data:e.allDeps,props:e.defaultProps,"default-expand-all":""},on:{"node-click":e.searchViewHandleNodeClick}}),i("div",{staticStyle:{width:"130px",display:"inline-flex","margin-top":"10px","margin-bottom":"-5px","font-size":"13px",border:"1px solid #dedede",height:"26px","border-radius":"5px",cursor:"pointer","align-items":"center","padding-left":"15px","box-sizing":"border-box"},attrs:{slot:"reference"},on:{click:e.showDepView},slot:"reference"},[i("span",{staticStyle:{color:"#DCDFE6"}},[e._v(e._s(e.inputDepName))])])],1)],1),i("el-col",{staticStyle:{"margin-top":"8px"},attrs:{span:10}},[e._v(" 入职日期： "),i("el-date-picker",{attrs:{type:"daterange","value-format":"yyyy-MM-dd","unlink-panels":"",size:"mini","range-separator":"至","start-placeholder":"开始日期","end-placeholder":"结束日期"},model:{value:e.searchValue.beginDateScope,callback:function(t){e.$set(e.searchValue,"beginDateScope",t)},expression:"searchValue.beginDateScope"}})],1),i("el-col",{staticStyle:{"margin-top":"10px"},attrs:{span:5,offset:4}},[i("el-button",{attrs:{size:"mini"},on:{click:e.calcelSearch}},[e._v("取消")]),i("el-button",{attrs:{size:"mini",type:"primary",icon:"el-icon-search"},on:{click:function(t){return e.initEmps("advanced")}}},[e._v(" 搜索 ")])],1)],1)],1)])],1),i("div",[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"100%","margin-top":"15px"},attrs:{data:e.emps,stripe:"",border:"",size:"small","element-loading-text":"正在加载数据...","element-loading-spinner":"el-icon-loading"}},[i("el-table-column",{attrs:{type:"selection",width:"55"}}),i("el-table-column",{attrs:{prop:"name",fixed:"",align:"left",label:"姓名",width:"120"}}),i("el-table-column",{attrs:{prop:"workID",label:"工号",width:"120"}}),i("el-table-column",{attrs:{prop:"gender",label:"性别",width:"80"}}),i("el-table-column",{attrs:{prop:"birthday",label:"出生日期",width:"150"}}),i("el-table-column",{attrs:{prop:"idCard",label:"身份证号码",width:"200"}}),i("el-table-column",{attrs:{prop:"wedlock",label:"婚姻状况",width:"100"}}),i("el-table-column",{attrs:{prop:"nation.name",label:"民族",width:"100"}}),i("el-table-column",{attrs:{prop:"nativePlace",label:"籍贯",width:"100"}}),i("el-table-column",{attrs:{prop:"politicsstatus.name",label:"政治面貌",width:"120"}}),i("el-table-column",{attrs:{prop:"email",label:"电子邮件",width:"180"}}),i("el-table-column",{attrs:{prop:"phone",label:"电话号码",width:"150"}}),i("el-table-column",{attrs:{prop:"address",label:"联系地址",width:"190"}}),i("el-table-column",{attrs:{prop:"department.name",label:"所属部门",width:"120"}}),i("el-table-column",{attrs:{prop:"position.name",label:"职位",width:"120"}}),i("el-table-column",{attrs:{prop:"jobLevel.name",label:"职称",width:"120"}}),i("el-table-column",{attrs:{prop:"engageForm",label:"聘用形式",width:"120"}}),i("el-table-column",{attrs:{prop:"beginDate",label:"入职日期",width:"160"}}),i("el-table-column",{attrs:{prop:"conversionTime",label:"转正日期",width:"160"}}),i("el-table-column",{attrs:{prop:"beginContract",label:"合同起始日期",width:"160"}}),i("el-table-column",{attrs:{prop:"endContract",label:"合同截止日期",width:"160"}}),i("el-table-column",{attrs:{label:"合同期限",width:"120"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-tag",{attrs:{size:"small"}},[e._v(e._s(t.row.contractTerm))]),e._v(" 年 ")]}}])}),i("el-table-column",{attrs:{prop:"tiptopDegree",label:"最高学历",width:"120"}}),i("el-table-column",{attrs:{prop:"gender",fixed:"right",label:"操作",width:"200"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{staticStyle:{padding:"3px"},attrs:{size:"small"},on:{click:function(i){return e.showEditEmpView(t.row)}}},[e._v("编辑")]),i("el-button",{staticStyle:{padding:"3px"},attrs:{size:"small",type:"primary"}},[e._v("查看高级资料")]),i("el-button",{staticStyle:{padding:"3px"},attrs:{size:"small",type:"danger"},on:{click:function(i){return e.deleteEmp(t.row)}}},[e._v("删除 ")])]}}])})],1),i("div",{staticStyle:{display:"flex","justify-content":"flex-end"}},[i("el-pagination",{attrs:{background:"",layout:"sizes, prev, pager, next, jumper, ->, total, slot",total:e.total},on:{"size-change":e.sizeChange,"current-change":e.currentChange}})],1)],1),i("el-dialog",{attrs:{title:e.dialogTitle,visible:e.dialogVisible,width:"80%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[i("div",[i("el-form",{ref:"empForm",attrs:{model:e.emp,rules:e.rules}},[i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"姓名：",prop:"name"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入员工姓名"},model:{value:e.emp.name,callback:function(t){e.$set(e.emp,"name",t)},expression:"emp.name"}})],1)],1),i("el-col",{attrs:{span:5}},[i("el-form-item",{attrs:{label:"性别：",prop:"gender"}},[i("el-radio-group",{model:{value:e.emp.gender,callback:function(t){e.$set(e.emp,"gender",t)},expression:"emp.gender"}},[i("el-radio",{attrs:{label:"男"}},[e._v("男")]),i("el-radio",{staticStyle:{"margin-left":"-10px"},attrs:{label:"女"}},[e._v("女")])],1)],1)],1),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"出生日期：",prop:"birthday"}},[i("el-date-picker",{staticStyle:{width:"160px"},attrs:{type:"date",size:"mini",format:"yyyy-MM-dd",placeholder:"出生日期"},model:{value:e.emp.birthday,callback:function(t){e.$set(e.emp,"birthday",t)},expression:"emp.birthday"}})],1)],1),i("el-col",{attrs:{span:7}},[i("el-form-item",{attrs:{label:"政治面貌：",prop:"politicId"}},[i("el-select",{staticStyle:{width:"180px"},attrs:{size:"mini",placeholder:"政治面貌"},model:{value:e.emp.politicId,callback:function(t){e.$set(e.emp,"politicId",t)},expression:"emp.politicId"}},e._l(e.politicsstatus,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1)],1)],1),i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"民族：",prop:"nationId"}},[i("el-select",{staticStyle:{width:"150px"},attrs:{size:"mini",placeholder:"请选择民族"},model:{value:e.emp.nationId,callback:function(t){e.$set(e.emp,"nationId",t)},expression:"emp.nationId"}},e._l(e.nations,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1)],1),i("el-col",{attrs:{span:5}},[i("el-form-item",{attrs:{label:"籍贯：",prop:"nativePlace"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"员工籍贯"},model:{value:e.emp.nativePlace,callback:function(t){e.$set(e.emp,"nativePlace",t)},expression:"emp.nativePlace"}})],1)],1),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"电子邮箱：",prop:"email"}},[i("el-input",{staticStyle:{width:"160px"},attrs:{size:"mini","prefix-icon":"el-icon-message",placeholder:"请输入电子邮箱..."},model:{value:e.emp.email,callback:function(t){e.$set(e.emp,"email",t)},expression:"emp.email"}})],1)],1),i("el-col",{attrs:{span:7}},[i("el-form-item",{attrs:{label:"联系地址：",prop:"address"}},[i("el-input",{staticStyle:{width:"180px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入联系地址..."},model:{value:e.emp.address,callback:function(t){e.$set(e.emp,"address",t)},expression:"emp.address"}})],1)],1)],1),i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"职位：",prop:"posId"}},[i("el-select",{staticStyle:{width:"150px"},attrs:{size:"mini",placeholder:"请选择职位"},model:{value:e.emp.posId,callback:function(t){e.$set(e.emp,"posId",t)},expression:"emp.posId"}},e._l(e.positions,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1)],1),i("el-col",{attrs:{span:5}},[i("el-form-item",{attrs:{label:"职称：",prop:"jobLevelId"}},[i("el-select",{staticStyle:{width:"150px"},attrs:{size:"mini",placeholder:"请选择职称"},model:{value:e.emp.jobLevelId,callback:function(t){e.$set(e.emp,"jobLevelId",t)},expression:"emp.jobLevelId"}},e._l(e.joblevels,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1)],1),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"所属部门：",prop:"departmentId"}},[i("el-popover",{attrs:{placement:"right",title:"请选择部门",width:"200",trigger:"manual"},model:{value:e.visible,callback:function(t){e.visible=t},expression:"visible"}},[i("el-tree",{attrs:{data:e.allDeps,props:e.defaultProps,"default-expand-all":""},on:{"node-click":e.handleNodeClick}}),i("div",{staticStyle:{width:"158px",display:"inline-flex","margin-top":"5px","margin-bottom":"-5px","font-size":"13px",border:"1px solid #dedede",height:"26px","border-radius":"5px",cursor:"pointer","align-items":"center","padding-left":"15px","box-sizing":"border-box"},attrs:{slot:"reference"},on:{click:e.showDepView},slot:"reference"},[e._v(e._s(e.inputDepName)+" ")])],1)],1)],1),i("el-col",{attrs:{span:7}},[i("el-form-item",{attrs:{label:"电话号码：",prop:"phone"}},[i("el-input",{staticStyle:{width:"180px"},attrs:{size:"mini","prefix-icon":"el-icon-phone",placeholder:"请输入电话号码..."},model:{value:e.emp.phone,callback:function(t){e.$set(e.emp,"phone",t)},expression:"emp.phone"}})],1)],1)],1),i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"工号：",prop:"workID"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{size:"mini",disabled:!0},model:{value:e.emp.workID,callback:function(t){e.$set(e.emp,"workID",t)},expression:"emp.workID"}})],1)],1),i("el-col",{attrs:{span:5}},[i("el-form-item",{attrs:{label:"学历：",prop:"tiptopDegree"}},[i("el-select",{staticStyle:{width:"150px"},attrs:{size:"mini",placeholder:"最高学历"},model:{value:e.emp.tiptopDegree,callback:function(t){e.$set(e.emp,"tiptopDegree",t)},expression:"emp.tiptopDegree"}},e._l(e.tiptopDegrees,(function(e){return i("el-option",{key:e,attrs:{label:e,value:e}})})),1)],1)],1),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"毕业院校：",prop:"school"}},[i("el-input",{staticStyle:{width:"180px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入毕业院校..."},model:{value:e.emp.school,callback:function(t){e.$set(e.emp,"school",t)},expression:"emp.school"}})],1)],1),i("el-col",{attrs:{span:7}},[i("el-form-item",{attrs:{label:"专业名称：",prop:"specialty"}},[i("el-input",{staticStyle:{width:"180px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入专业名称..."},model:{value:e.emp.specialty,callback:function(t){e.$set(e.emp,"specialty",t)},expression:"emp.specialty"}})],1)],1)],1),i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"入职日期：",prop:"beginDate"}},[i("el-date-picker",{staticStyle:{width:"160px"},attrs:{type:"date",size:"mini",format:"yyyy-MM-dd",placeholder:"入职日期"},model:{value:e.emp.beginDate,callback:function(t){e.$set(e.emp,"beginDate",t)},expression:"emp.beginDate"}})],1)],1),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"转正日期：",prop:"conversionTime"}},[i("el-date-picker",{staticStyle:{width:"160px"},attrs:{type:"date",size:"mini",format:"yyyy-MM-dd",placeholder:"转正日期"},model:{value:e.emp.conversionTime,callback:function(t){e.$set(e.emp,"conversionTime",t)},expression:"emp.conversionTime"}})],1)],1),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"合同起始日期：",prop:"beginContract"}},[i("el-date-picker",{staticStyle:{width:"160px"},attrs:{type:"date",size:"mini",format:"yyyy-MM-dd",placeholder:"合同起始日期"},model:{value:e.emp.beginContract,callback:function(t){e.$set(e.emp,"beginContract",t)},expression:"emp.beginContract"}})],1)],1),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"合同终止日期：",prop:"endContract"}},[i("el-date-picker",{staticStyle:{width:"160px"},attrs:{type:"date",size:"mini",format:"yyyy-MM-dd",placeholder:"合同终止日期"},model:{value:e.emp.endContract,callback:function(t){e.$set(e.emp,"endContract",t)},expression:"emp.endContract"}})],1)],1)],1),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"身份证号码：",prop:"idCard"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入员工身份证号码..."},model:{value:e.emp.idCard,callback:function(t){e.$set(e.emp,"idCard",t)},expression:"emp.idCard"}})],1)],1),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"聘用形式：",prop:"engageForm"}},[i("el-radio-group",{model:{value:e.emp.engageForm,callback:function(t){e.$set(e.emp,"engageForm",t)},expression:"emp.engageForm"}},[i("el-radio",{attrs:{label:"劳动合同"}},[e._v("劳动合同")]),i("el-radio",{staticStyle:{"margin-left":"-10px"},attrs:{label:"劳务合同"}},[e._v("劳务合同")])],1)],1)],1),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"婚姻状况：",prop:"wedlock"}},[i("el-radio-group",{model:{value:e.emp.wedlock,callback:function(t){e.$set(e.emp,"wedlock",t)},expression:"emp.wedlock"}},[i("el-radio",{attrs:{label:"未婚"}},[e._v("未婚")]),i("el-radio",{staticStyle:{"margin-left":"-10px"},attrs:{label:"已婚"}},[e._v("已婚")]),i("el-radio",{staticStyle:{"margin-left":"-10px"},attrs:{label:"离异"}},[e._v("离异")])],1)],1)],1)],1)],1)],1),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{size:"small"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),i("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.doAddEmp}},[e._v("确 定")])],1)])],1)},l=[],s=(i("b0c0"),{name:"EmpBasic",data:function(){return{emps:[],loading:!1,visible:!1,dialogVisible:!1,total:0,page:1,size:10,keyword:"",inputDepName:"所属部门...",dialogTitle:"",importDataText:"导入数据",importDataIcon:"el-icon-upload2",importDisabled:!1,showAdvanceSearchView:!1,politicsstatus:[],nations:[],positions:[],joblevels:[],allDeps:[],tiptopDegrees:["本科","大专","博士","硕士","高中","初中","小学","其他"],emp:{name:"韩信",gender:"男",birthday:"1989-12-31 08:00:00",idCard:"610122199301054789",wedlock:"已婚",nationId:1,nativePlace:"陕西西安",politicId:1,email:"yunxing@qq.com",phone:"15644442252",address:"陕西西安新城区",departmentId:null,jobLevelId:16,posId:34,engageForm:"劳务合同",tiptopDegree:"硕士",specialty:"通信工程",school:"西安电子科技学校",beginDate:"2018-01-01 08:00:00",workID:"00000006",contractTerm:5.25,conversionTime:"2018-04-01 08:00:00",notWorkDate:null,beginContract:"2018-01-01 08:00:00",endContract:"2023-04-13 08:00:00",workAge:null},defaultProps:{children:"children",label:"name"},rules:{name:[{required:!0,message:"请填写姓名",trigger:"blur"}],birthday:[{required:!0,message:"请选择出生日期",trigger:"blur"}],nativePlace:[{required:!0,message:"请填写籍贯",trigger:"blur"}],email:[{required:!0,message:"请填写电子邮箱",trigger:"blur"},{type:"email",message:"邮箱格式不正确",trigger:"blur"}],address:[{required:!0,message:"请填写联系地址",trigger:"blur"}],departmentId:[{required:!0,message:"请选择部门",trigger:"blur"}],phone:[{required:!0,message:"请填写电话号码",trigger:"blur"}],school:[{required:!0,message:"请填写毕业院校",trigger:"blur"}],specialty:[{required:!0,message:"请填写专业名称",trigger:"blur"}],beginDate:[{required:!0,message:"请选择入职日期",trigger:"blur"}],conversionTime:[{required:!0,message:"请选择转正日期",trigger:"blur"}],beginContract:[{required:!0,message:"请选择合同起始日期",trigger:"blur"}],endContract:[{required:!0,message:"请选择合同终止日期",trigger:"blur"}],idCard:[{required:!0,message:"请填写身份账号",trigger:"blur"},{pattern:/(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/,message:"身份证号码格式不正确",trigger:"blur"}]},searchValue:{politicId:null,nationId:null,posId:null,jobLevelId:null,engageForm:null,departmentId:null,beginDateScope:null}}},mounted:function(){this.initEmps(),this.initData(),this.initPositions()},methods:{calcelSearch:function(){this.showAdvanceSearchView=!this.showAdvanceSearchView,this.initEmps()},searchViewHandleNodeClick:function(e){this.inputDepName=e.name,this.searchValue.departmentId=e.id,this.visible=!this.visible},onError:function(){this.importDataText="导入数据",this.importDataIcon="el-icon-upload2",this.importDisabled=!1,this.initEmps(),this.$message.success("导入失败！")},onSuccess:function(){this.importDataText="导入数据",this.importDataIcon="el-icon-upload2",this.importDisabled=!1,this.initEmps(),this.$message.success("导入成功！")},beforeUpload:function(){this.importDataText="正在导入",this.importDataIcon="el-icon-loading",this.importDisabled=!0},exportData:function(e){var t="/employee/basic/export?page="+this.page+"&size="+this.size;e&&"advanced"==e&&(this.searchValue.politicId&&(t+="&politicId="+this.searchValue.politicId),this.searchValue.nationId&&(t+="&nationId="+this.searchValue.nationId),this.searchValue.posId&&(t+="&posId="+this.searchValue.posId),this.searchValue.jobLevelId&&(t+="&jobLevelId="+this.searchValue.jobLevelId),this.searchValue.departmentId&&(t+="&departmentId="+this.searchValue.departmentId),this.searchValue.engageForm&&(t+="&engageForm="+this.searchValue.engageForm),this.searchValue.beginDateScope&&(t+="&beginDateScope="+this.searchValue.beginDateScope),this.keyword&&(t+="&name="+this.keyword)),window.open(t,"_parent")},emptyEmp:function(){this.emp={name:"",gender:"",birthday:"",idCard:"",wedlock:"",nationId:1,nativePlace:"",politicId:1,email:"",phone:"",address:"",departmentId:null,jobLevelId:16,posId:34,engageForm:"",tiptopDegree:"",specialty:"",school:"",beginDate:"",workID:"",contractTerm:"",conversionTime:"",notWorkDate:null,beginContract:"",endContract:"",workAge:null},this.inputDepName=""},showEditEmpView:function(e){this.initPositions(),this.dialogTitle="编辑员工信息",this.emp=e,this.inputDepName=e.department.name,this.dialogVisible=!0},deleteEmp:function(e){var t=this;this.$confirm("此操作将永久删除【"+e.name+"】员工, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.deleteRequest("/employee/basic/"+e.id).then((function(e){e&&t.initEmps()}))})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},doAddEmp:function(){var e=this;this.emp.id?this.$refs.empForm.validate((function(t){t&&e.putRequest("/employee/basic/",e.emp).then((function(t){t&&(e.dialogVisible=!1,e.initEmps())}))})):this.$refs.empForm.validate((function(t){t&&e.postRequest("/employee/basic/",e.emp).then((function(t){t&&(e.dialogVisible=!1,e.initEmps())}))}))},handleNodeClick:function(e){this.inputDepName=e.name,this.emp.departmentId=e.id,this.visible=!this.visible},showDepView:function(){this.visible=!this.visible},getmaxWorkID:function(){var e=this;this.getRequest("/employee/basic/maxWorkID").then((function(t){t&&(e.emp.workID=t.obj)}))},initPositions:function(){var e=this;this.getRequest("/employee/basic/positions").then((function(t){t&&(e.positions=t)}))},initData:function(){var e=this;window.sessionStorage.getItem("politicsstatus")?this.politicsstatus=JSON.parse(window.sessionStorage.getItem("politicsstatus")):this.getRequest("/employee/basic/politicsstatus").then((function(t){t&&(e.politicsstatus=t,window.sessionStorage.setItem("politicsstatus",JSON.stringify(t)))})),window.sessionStorage.getItem("nations")?this.nations=JSON.parse(window.sessionStorage.getItem("nations")):this.getRequest("/employee/basic/nations").then((function(t){t&&(e.nations=t,window.sessionStorage.setItem("nations",JSON.stringify(t)))})),window.sessionStorage.getItem("joblevels")?this.joblevels=JSON.parse(window.sessionStorage.getItem("joblevels")):this.getRequest("/employee/basic/joblevels").then((function(t){t&&(e.joblevels=t,window.sessionStorage.setItem("joblevels",JSON.stringify(t)))})),window.sessionStorage.getItem("allDeps")?this.allDeps=JSON.parse(window.sessionStorage.getItem("allDeps")):this.getRequest("/employee/basic/departments").then((function(t){t&&(e.allDeps=t,window.sessionStorage.setItem("allDeps",JSON.stringify(t)))}))},showAddEmpView:function(){this.getmaxWorkID(),this.emptyEmp(),this.dialogTitle="添加员工",this.dialogVisible=!0},sizeChange:function(e){this.size=e,this.initEmps("advanced")},currentChange:function(e){this.page=e,this.initEmps("advanced")},initEmps:function(e){var t=this;this.loading=!0;var i="/employee/basic/?page="+this.page+"&size="+this.size;e&&"advanced"==e?(this.searchValue.politicId&&(i+="&politicId="+this.searchValue.politicId),this.searchValue.nationId&&(i+="&nationId="+this.searchValue.nationId),this.searchValue.posId&&(i+="&posId="+this.searchValue.posId),this.searchValue.jobLevelId&&(i+="&jobLevelId="+this.searchValue.jobLevelId),this.searchValue.departmentId&&(i+="&departmentId="+this.searchValue.departmentId),this.searchValue.engageForm&&(i+="&engageForm="+this.searchValue.engageForm),this.searchValue.beginDateScope&&(i+="&beginDateScope="+this.searchValue.beginDateScope)):this.keyword&&(i+="&name="+this.keyword),this.getRequest(i).then((function(e){t.loading=!1,e&&(t.emps=e.data,t.total=e.total)}))}}}),o=s,n=(i("ec21"),i("2877")),r=Object(n["a"])(o,a,l,!1,null,null,null);t["default"]=r.exports},8759:function(e,t,i){"use strict";i.r(t);var a=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",[e._v(" 高级资料 ")])},l=[],s={name:"EmpAdv"},o=s,n=i("2877"),r=Object(n["a"])(o,a,l,!1,null,"3cb7796b",null);t["default"]=r.exports},c6ed:function(e,t,i){},ec21:function(e,t,i){"use strict";var a=i("c6ed"),l=i.n(a);l.a}}]);
//# sourceMappingURL=chunk-32db800e.480fddb4.js.map