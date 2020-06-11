-- soma da população agrupadas por região
select 
	regiao as 'Região',
    sum(populacao) as Total
from estados
group by regiao
order by Total desc;

-- soma da população
select sum(populacao) as Total from estados;

-- media da população
select avg(populacao) from estados;