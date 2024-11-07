# Jogo-Cata-Frutas

Este Jogo é um projeto acadêmico para avaliação da matéria de Programação Orientada a Objetos em Java com o intuito de aprendizado e prática dos conehcimentos do paradigma orientado a objetos.

O jogo tem como ideia dois jogadres que irão competir entre si, onde os competidores irão catar frutas e guarda-las em sua mochila, algumas das frutas tem um efeito especial, mas para vencer, é necessário ter mais da metade da fruta ouro definida na configuração do jogo.

# Cenário
Para o cenário do jogo, foi utilizado uma matriz quadrada onde cada célula é composto grama, pedras, frutas e árvores. Para preenchimento do mesmo, temos objetos das classes de cada um desses componentes e para algo visual disso, foi colocado imagens dos objetos alocados na matriz.

# Jogadores
Os jogadores são posicionados aleatoriamente no cenário e para movimentação eles devem a cada rodada girar um dado, o valor do mesmo será a quantidade de passos que ele deverá dar. Cada passo custa um movimento, a não ser que uma pedra esteja no caminho, que para atravessá-la, será necessário 3 pontos de movimento. Ambos os jogadores podem empurrar un aos outros para uma dinãmica de competitiviedae, no qual quando se encontrarem a ação de empurrar pode ser acionada e assim derruar as frutas do oponente.

# Frutas
Cada fruta possui um efeito especial, sendo elas:

● maracujá (fruta ouro): um ponto de vitória;

● coco (agilidade): dobra o número de pontos de movimento de uma rodada;

● abacate (força): dobra a força do competidor;

● laranja (antídoto): anula o efeito do consumo de uma fruta bichada (mais sobre isso a seguir); Frutas sem propriedades extras, o número de cada tipo é aleatório:

● acerola; 

● amora;

● goiaba.

Cada fruta possui um peso para o jogador que é convertido em força para ele, no qual essa força influencia na potência do empurrão, que poderá fazer com que mais frutas da mochila do oponente caia no chão. As frutas que não tem efeito apenas só possui o peso e nada mais.

# Configuração do jogo

Lógica das configurações do jogo:

● A dimensão m da floresta (m >=3);

● O número de pedras (o restante da floresta é ocupada por grama);

● O número total de frutas ouro (deve ser no mínimo 1);

● O número de cada tipo de fruta não-ouro que estará no chão no início do jogo (agilidade, força, antídoto, ou sem propriedade extra) e os tipos de árvores desejados para aquela partida e a quantidade de árvores de cada tipo. A quantidade não pode ultrapassar o limite de células com grama. Não existem árvores de maracujá - a planta cresce se apoiando em outras (mais sobre isso na seção “Vitória”);

● A chance de uma fruta estar bichada (até as frutas ouro podem estar bichadas);

● Capacidade da mochila do competidor - em número de frutas;

# Interface

Para a criação da interface, foi usado o Swing do java juntamente com o Window Builder, que facilita na criação dos paineis e janelas de forma mais dinãmica.

# Conclusão

Isto é apenas uma breve descrição do jogo e seu funcionamento, para mais detalhes, foi deixado neste repositório o PDF que contém todas as regras do mesmo feito pela prof.Beatriz Trinchão Andrade e seus colaboradores. Alpem disso, o jogo não se encontra na sua versão final, alguns bugs ainda estão presentes nele e nem todas as funcionalidades estão implementada.
 
# Autora do jogo e colaboradores
Professora: Beatriz Trinchão Andrade 
Colaboração: prof. André Britto e Mislene Nunes

# Autor do código fonte do Jogo
David Alessandro Santos Souza
