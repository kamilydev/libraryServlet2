import com.servlet.aula.projetobibliotecaservlet.models.Book;

function deleteBook(isbn) {
    $.ajax({
        url: 'excluir',
        type: 'DELETE',
        data: { isbn: isbn },
        success: function(response) {
            alert('Livro excluído com sucesso!');
            location.reload();
        },
        error: function(xhr, status, error) {
            alert('Erro ao excluir livro: ' + error);
        }
    });
}