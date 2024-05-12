// 삭제 기능

const deleteButton = document.getElementById('delete-btn');
const modifyButton = document.getElementById('modify-btn');
const createButton = document.getElementById('create-btn');

if (deleteButton) {
  deleteButton.addEventListener('click', event => {
    let id = document.getElementById('article-id').value;
    fetch(`/api/article/${id}`, {
      method: 'DELETE'
    })
    .then(() => {
      alert('삭제가 완료되었습니다.');
      location.replace('/articles');
    });
  });

}



// 수정 기능
// id 가 modify-btn 인 엘리먼트 조회


if (modifyButton) {
  // 클릭 이벤트 감지되면 수정 API 요청
  modifyButton.addEventListener('click', event => {
    let params = new URLSearchParams(location.search);
    let id = params.get('id');

    fetch(`/api/article/${id}`, {
      method: 'PUT',
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        title: document.getElementById('title').value,
        content: document.getElementById('content').value
      })
    })
    .then(() => {
      alert('수정이 완료되었습니다.');
      location.replace(`/articles/${id}`);
    });
  })
}

if(createButton) {
  createButton.addEventListener('click',event=>{
    fetch('/api/articles',{
      method:'POST',
      headers:{
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        title: document.getElementById('title').value,
        content: document.getElementById('content').value
      })
    }).then(()=>{
      alert('등록이 완료되었습니다.');
      location.replace('/articles');
    });
  });
}
