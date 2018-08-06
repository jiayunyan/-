/**
 * Created by zhanghongbin01 on 2015/5/24.
 */
$(document).ready(function(){
    $('#bns_group_save').hide();
    $('#bns_group_edit').hide();
    $("#bns_group_delete").hide();

    $('#bns_create').click(function(){
        $('#bns_group_save').show();
    });
    $('#btn_bns_group_save').click(function(){
        alert('BNS group save success!');
        $('#bns_group_save').hide();
    });

    $('#bns_group_cancle').click(function(){
        $('#bns_group_save').hide();
    });

    $('#bns_edit').click(function(){
        $('#bns_group_edit').show();
    });
    $('#btn_bns_group_edit_save').click(function(){
        alert('BNS group modify success!');
        $('#bns_group_edit').hide();
    });

    $('#bns_group_edit_cancle').click(function(){
        $('#bns_group_edit').hide();
    });

    $("#link_bns_group_delete").click(function(){
        $("#bns_group_delete").show();
    });

   $("#btn_bns_group_delete_ok").click(function(){
       alert("Remove the BNS group success...");
       $("#bns_group_delete").hide();
   });

    $("#btn_bns_group_delete_cancle").click(function(){
        $("#bns_group_delete").hide();
    });

});


