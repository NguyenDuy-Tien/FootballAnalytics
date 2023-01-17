import pandas as pd
from pathlib import Path  
filepath = Path('output/out.csv')  
filepath.parent.mkdir(parents=True, exist_ok=True)  

player_df = pd.read_csv("./input/data.csv")
list_preimer_league = ["Bournemouth,", "Arsenal,", "Aston Villa,", "Brentford,", "Brighton,", "Chelsea,", "Crystal Palace,", "Everton,", "Fulham,",
                       "Leeds,", "Leicester,", "Liverpool,", "Man City,", "Man Utd,", "Newcastle,", "Nottingham Forest,", "Southampton,", "Tottenham,", "West Ham,", "Wolves,"]
list_ligue1 = ["AC Ajaccio,", "Auxerre,", "Angers,", "Monaco,", "Clermont Foot,", "Troyes,", "Lorient,", "Nantes,", "Lille,",
               "Montpellier,", "Nice,", "Marseille,", "Lyon,", "PSG,", "Lens,", "Strasbourg,", "Brest,", "Reims,", "Rennes,", "Toulouse,"]
list_bundesliga = ["Eintracht Frankfurt,", "Augsburg,", "Leverkusen,", "Bayern,", "Bochum,", "Borussia Dortmund,", "Borussia M.Gladbach,", "Freiburg,",
                   "Hertha Berlin,", "Hoffenheim,", "FC Koln,", "RBL,", "Mainz,", "Schalke,", "Stuttgart,", "Union Berlin,", "Werder Bremen,", "Wolfsburg,"]
list_serieA = ["Napoli,", "Juventus,", "AC Milan,", "Inter,", "Lazio,", "Atalanta,", "Roma,", "Udinese,", "Fiorentina,", "Torino,",
               "Lecce,", "Bologna,", "Empoli,", "Salernitana,", "Monza,", "Sassuolo,", "Spezia,", "Verona,", "Sampdoria,", "Cremonese,"]
list_la_liga = ["Villarreal,", "Barcelona,", "Real Madrid,", "Real Sociedad,", "Real Betis,", "Atletico,", "Athletic Bilbao,", "Osasuna,", "Rayo Vallecano,",
                "Mallorca,", "Valencia,", "Girona,", "Getafe,", "Almeria,", "Real Valladolid,", "Celta Vigo,", "Sevilla,", "Cadiz,", "Espanyol,", "Elche,"]
list_test = list_bundesliga + list_la_liga + list_ligue1 + list_preimer_league + list_serieA
player_df.insert(3, "league", ["test"] * 1446)

for i in range(player_df.shape[0]):
    if player_df.loc[i]['team'] in list_preimer_league:
        player_df.at[i, 'league'] = "Premier League"
    if player_df.loc[i]['team'] in list_la_liga:
        player_df.at[i, 'league'] = "La Liga"
    if player_df.loc[i]['team'] in list_ligue1:
        player_df.at[i, 'league'] = "Ligue 1"
    if player_df.loc[i]['team'] in list_bundesliga:
        player_df.at[i, 'league'] = "Bundesliga"
    if player_df.loc[i]['team'] in list_serieA:
        player_df.at[i, 'league'] = "Serie A"
player_df.to_csv(filepath)
