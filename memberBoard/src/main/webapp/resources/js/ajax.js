var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
//수정폼
function modiReply(rno,writer,content,bno){
	var modiHtml = `
		<div>
			<p>
				<label>댓글 작성자</label> <input type="text" value="${writer}" readonly disabled>
			</p>
			<p>
				<textarea rows="5" cols="50" id="modiContent">${content}</textarea>
			</p>
			<p>
				<button onclick="updateReply(${rno},${bno})">댓글 수정</button>
				<button onclick="showReplyList()">취소</button>
			</p>
		</div>
	`;
	$('#rno'+rno).replaceWith(modiHtml);
	$('#modiContent').focus();
}


function updateReply(rno,bno){
	var re_content = $('#modiContent').val();
	var dataOption = JSON.stringify({	
						"re_content" : re_content,
						"rno" : rno, 
						"bno" : bno })
	
	$.ajax({
		url : "/reply/updateReply",
		headers : { "Content-type" : "application/json", "X-HTTP-Method-Override" : "POST" },
		dataType : "text",
		data : dataOption,
		type : "post",
		beforeSend:function(xhr){
			xhr.setRequestHeader(header,token);
		},
		success : function(result){
			console.log("success")
			showReplyList();
		}
	})
}




//댓글리스트 보여주기 위한 메소드
function showReplyList(num){
	var re_bno = $('#bno').val();
	console.log(re_bno+"==>")
	var data = {"bno": re_bno,
				"num": num }
	
	$.ajax({
		//url : "${pageContext.request.contextPath}/reply/getReply",
		url : "/reply/getReply",
		dataType : "json",
		data : data,
		success : function(data){
			
			var replyList = data.list;
			var page = data.page;
			var str = "";
			var paging = "";

			//댓글 리스트
			$(replyList).each(function(idx,item){
				str +="<div class='reList ajax'>"
				str +=	"<li id=rno"+this.rno+">"
				str +=		"<p>댓글작성자 :"+this.re_writer+"</p>"
				str +=		"<p>댓글내용 :"+this.re_content+"</p>"
				str +=		"<button onclick='modiReply(\""+this.rno+"\",\""+this.re_writer+"\",\""+this.re_content+"\",\""+re_bno+"\")'>수정</button>"
				str +=		"<button onclick='deleteReply(\""+this.rno+"\")'>삭제</button>"
				str +=	"</li>"
				str +="</div>"
				
				$('#replyList').html(str);
				
			})
			
			//댓글 페이징 처리
			for(var num = page.startPageNum; num <= page.endPageNum; num++){
				
				if(num == page.num){
					paging += '<b class="pagebtn'+num+' ad" style="display:none">' + num + '</b>';
				} else {
					paging += '<span>'
					paging += '<a href="#" onclick="showReplyList(' + num + '); return false;" class="pagebtn'+num+' ad"; style="display:none" >' + num + '</a>';
					paging += '</span>'
				}
				$('#replyPaging').html(paging);
				
				
			} //for end
			
			//댓글이 달려있을경우 페이지번호 show
			if( $('.reList').hasClass('ajax')  ){
				$('.ad').show();
//				var a =  $('.ajax li').length;
			} else {
				str += `<div>댓글이 없습니다.</div>`;
				$('#replyList').html(str);
			}
			
			
			/*for(var num = page.startPageNum; num <= page.endPageNum; num++){
			if( $('.reList').hasClass('ajax')  ){
				//			console.log($('.ad').length)				
				//$('.ad').show();
				//리플갯수
				var replyLen =  $('.ajax li').length;
				var b = num;
				var a = num + 1;
				
				console.log("b===>"+b)
				console.log("a===>"+a)
				$('.pagebtn'+b).show();
				if(replyLen == page.postNum){
					$('.pagebtn'+a).show();
				} else {
					console.log("re")
					$('.pagebtn'+num).show();
				}
				
				
			} else {
				str += `<div>댓글이 없습니다.</div>`;
				$('#replyList').html(str);
			}
			}*/
			
		}
		
	})//ajax end	
	
}



//댓글 작성 메소드
function sendReply(){
	var bno = $('#bno').val();
	var re_reWriter = $('#reWriter').val();
	var re_reContent = $('#reContent').val();
	
	var paramData = JSON.stringify(
		{"re_content": re_reContent,
		 "re_writer": re_reWriter,
		 "bno": bno }
		);
	
	 $.ajax({
		type : "post",
		url : "/reply/regReply",
		headers : { "Content-type" : "application/json", "X-HTTP-Method-Override" : "POST" },
		dataType : "text",
		data : paramData,
		beforeSend:function(xhr){
			xhr.setRequestHeader(header,token);
		},
		success : function (result) {
				console.log(result)
				showReplyList();
				$('#reWriter').val("");
				$('#reContent').val("");
			}
		
	}); 
	
}

//댓글 삭제 
function deleteReply(rno){
	
	var dataOption = {"rno" : rno}
	
	$.ajax({
		type : "post",
		url : "/reply/deleteReply",
		dataType : "json",
		data : dataOption,
		beforeSend:function(xhr){
			xhr.setRequestHeader(header,token);
		},
		success : function(result){
			alert("delete")
			showReplyList();
		}
	})
	
	
}

