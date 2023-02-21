/*
 *    Copyright 2023 KPG-TB
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.github.kpgtb.ktools.manager.command.parser.spigot;

import com.github.kpgtb.ktools.manager.command.IParamParser;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerParser implements IParamParser<Player> {
    @Override
    public Player convert(String param) {
        return Bukkit.getPlayer(param);
    }

    @Override
    public boolean canConvert(String param) {
       return convert(param) != null;
    }

    @Override
    public List<String> complete(String arg, CommandSender sender) {
        return Bukkit.getOnlinePlayers().stream()
                .map(HumanEntity::getName)
                .filter(s -> s.startsWith(arg))
                .limit(10)
                .collect(Collectors.toList());
    }
}
