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
        .then(async response => {

            // Se der erro (400, 404, 500 etc)
            if (!response.ok) {
                const errorMessage = await response.text();
                alert("CPF já cadastrado no sistema");
                throw new Error(errorMessage);
            }

            return response.json();
        })
        .then(data => {
            alert("Usuário cadastrado com sucesso! ID: " + data.id);

            document.getElementById("nome").value = "";
            document.getElementById("cpf").value = "";
            document.getElementById("senha").value = "";
        })
        .catch(error => {
            console.error(error);
        });
    });
}
