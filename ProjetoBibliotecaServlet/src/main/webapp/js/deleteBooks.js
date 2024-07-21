let isbnToDelete = null;

function showModal(isbn) {
    isbnToDelete = isbn;
    document.getElementById('modal').showModal();
}

function confirmDelete() {
    if (isbnToDelete) {
        $.ajax({
            url: 'excluir',
            type: 'POST',
            data: { isbn: isbnToDelete },
            success: function(response) {
                alert('Livro excluído com sucesso!');
                location.reload();
            },
            error: function(xhr, status, error) {
                alert('Erro ao excluir livro: ' + error);
            }
        });
        document.getElementById('modal').close();
    }
}
