package com.dragovorn.dotaapi.match;

import com.dragovorn.dotaapi.match.team.DotaTeam;
import com.dragovorn.dotaapi.match.team.ITeam;
import com.dragovorn.dotaapi.match.team.TeamSide;
import org.json.JSONObject;

import java.util.Date;

/**
 * Default implementation of {@link com.dragovorn.dotaapi.IDota}.
 *
 * @author Andrew Burr
 * @version 0.4
 * @since 0.0.1
 */
public class DotaMatch implements IMatch {

    private final ITeam radiant;
    private final ITeam dire;

    private final Date startTime;

    private final long matchId;
    private final long matchSeqId;

    private final int duration;
    private final int firstBlood;

    private final boolean radiantWin;

    public DotaMatch(JSONObject object) {
        this.startTime = new Date(object.getLong("start_time"));
        this.matchId = object.getLong("match_id");
        this.matchSeqId = object.getLong("match_seq_num");
        this.duration = object.getInt("duration");
        this.firstBlood = object.getInt("first_blood_time");
        this.radiantWin = object.getBoolean("radiant_win");
        this.radiant = new DotaTeam(TeamSide.RADIANT, object.getInt("tower_status_radiant"), object.getInt("barracks_status_radiant"), this.radiantWin);
        this.dire = new DotaTeam(TeamSide.DIRE, object.getInt("tower_status_dire"), object.getInt("barracks_status_dire"), !this.radiantWin);
    }

    @Override
    public boolean didRadiantWin() {
        return this.radiantWin;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    @Override
    public int getFirstBlood() {
        return this.firstBlood;
    }

    @Override
    public long getMatchId() {
        return this.matchId;
    }

    @Override
    public long getSequenceId() {
        return this.matchSeqId;
    }

    @Override
    public Date getStartTime() {
        return this.startTime;
    }

    @Override
    public ITeam getRadiant() {
        return this.radiant;
    }

    @Override
    public ITeam getDire() {
        return this.dire;
    }

    @Override
    public ITeam getWinner() {
        return (this.radiantWin ? this.radiant : this.dire);
    }
}