const addBtn = document.querySelector('.add');
			 addBtn.addEventListener('click', function() {
	const newDiv = document.createElement('div');
		 newDiv.className = 'upload_btn';
				        
	 const input = document.createElement('input');
	 		input.name = 'uploadFile';
			input.type = 'file';
				        
	const deleteBtn = document.createElement('button');
				      deleteBtn.type = 'button';
				      deleteBtn.textContent = '삭제';
				      deleteBtn.addEventListener('click', function() {
				      newDiv.remove();
	})
	
	 newDiv.appendChild(input);
	 newDiv.appendChild(deleteBtn);
	
	document.querySelector('.upload_sec').appendChild(newDiv);
})