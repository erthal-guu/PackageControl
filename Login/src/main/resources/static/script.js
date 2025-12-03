
document.getElementById("cpf").addEventListener("input", function () {
    let cpf = this.value.replace(/\D/g, "");

    cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2");
    cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2");
    cpf = cpf.replace(/(\d{3})(\d)/, "$1-$2");

    this.value = cpf;
});


function ObterRequisicao() {

    document.getElementById("formCadastro").addEventListener("submit", function (e) {
        e.preventDefault();

        const dados = {
            name: document.getElementById("nome").value,
            cpf: document.getElementById("cpf").value,
            senha: document.getElementById("senha").value
        };

        fetch("/usuarios/cadastrar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(dados)
        })
        .then(response => response.json())
        .then(data => {
            alert("Usuário cadastrado com sucesso! ID: " + data.id);

            document.getElementById("nome").value = "";
            document.getElementById("cpf").value = "";
            document.getElementById("senha").value = "";
        })
        .catch(error => {
            alert("Erro ao cadastrar: " + error);
        });
    });
}

