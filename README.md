### Contexto

Como projeto final da disciplina de Programação Orientada a Objetos, desenvolvi um sistema de gestão completo para a Academia Milho Verde. A aplicação, construída em **Java**, atende aos requisitos do projeto, que incluíam o gerenciamento de agendamentos, clientes, funcionários e financeiro.

--------

### Problema

Quando me aposentar, quero abrir uma academia em Milho Verde. A academia terá 4 salas para exercícios (spinning, musculação, fit dance e pilates) Também teremos uma lanchonete e uma pequena loja de material de academia. Preciso de um sistema para gerenciar as diárias, mensalidades, de forma geral para monitorar despesas e ganhos. Quando um cliente potencial telefonar para fazer a reserva, eu verificarei a agenda e, se existir vaga, entrarei com os dados do cliente (Nome, endereço, número do telefone, e-mail e CPF pseudo-anonimizado). Em seguida, farei um agendamento preliminar, entrando com a escolha da aula e a(s) data(s) escolhida(s), o preço que será cobrado, número do cartão de crédito, o tipo de aula e o instrutor que irá acompanhar as atividades. Um agendamento preliminar se torna definitivo se o cliente confirmar, até 5 dias úteis antes de acessar a academia. Como recebemos muitos turistas, pretendo ter um grande enfoque em diárias, mas iremos trabalhar com mensalidades também. Na confirmação do cliente será debitada a diária ou mensalidade no cartão de crédito do cliente. Se o cliente não confirmar, o agendamento será cancelado. Se, após a confirmação, o cliente desistir, até três dias antes da data marcada, será devolvida metade do valor cobrado. É fundamental que eu saiba quantas pessoas estão na academia e quem entrou e saiu, em quais horários e dias, para isso vou usar um sistema de catraca externo, mas preciso que o sistema da academia contabilize todas as ações dos meus clientes. Este mesmo sistema deve possibilitar o lançamento das despesas da academia (limpeza, instrutores e funcionários, material de uso diário, etc…), emitir a "conta" de cada cliente, e o gerenciamento das despesas da academia. Também, deve possibilitar, ao final de cada mês, fazer um balanço das receitas e despesas do mês. Além de mim, os funcionários da academia terão acesso a todas as funcionalidades, exceto ao gerenciamento das despesas da academia e ao balanço mensal de receitas e despesas. Para acesso, é necessário autenticação do usuário.

--------

### Tecnologias

Desenvolvido como projeto final da disciplina de Programação Orientada a Objetos, este sistema utiliza **Java** como linguagem principal e **JSON** para a troca de dados.