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

package com.github.kpgtb.ktools.util;

import com.github.kpgtb.ktools.manager.cache.CacheManager;
import com.github.kpgtb.ktools.manager.data.DataManager;
import com.github.kpgtb.ktools.manager.debug.DebugManager;
import com.github.kpgtb.ktools.manager.language.LanguageManager;
import com.github.kpgtb.ktools.manager.command.parser.ParamParserManager;
import com.github.kpgtb.ktools.manager.resourcepack.ResourcepackManager;
import com.github.kpgtb.ktools.manager.ui.UiManager;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Wrapper with all necessary objects
 */
public class ToolsObjectWrapper {
    private final CacheManager cacheManager;
    private final DebugManager debugManager;
    private final LanguageManager languageManager;
    private final JavaPlugin plugin;
    private final BukkitAudiences adventure;
    private final ParamParserManager paramParserManager;
    private final DataManager dataManager;
    private final ResourcepackManager resourcepackManager;
    private final UiManager uiManager;

    public ToolsObjectWrapper(CacheManager cacheManager, DebugManager debugManager, LanguageManager languageManager, JavaPlugin plugin, BukkitAudiences adventure, ParamParserManager paramParserManager, DataManager dataManager, ResourcepackManager resourcepackManager, UiManager uiManager) {
        this.cacheManager = cacheManager;
        this.debugManager = debugManager;
        this.languageManager = languageManager;
        this.plugin = plugin;
        this.adventure = adventure;
        this.paramParserManager = paramParserManager;
        this.dataManager = dataManager;
        this.resourcepackManager = resourcepackManager;
        this.uiManager = uiManager;
    }

    public ToolsObjectWrapper(GlobalManagersWrapper globalManagersWrapper, LanguageManager languageManager, JavaPlugin plugin, BukkitAudiences adventure) {
        this.cacheManager = globalManagersWrapper.getCacheManager();
        this.debugManager = globalManagersWrapper.getDebugManager();
        this.paramParserManager = globalManagersWrapper.getParamParserManager();
        this.dataManager = globalManagersWrapper.getDataManager();
        this.resourcepackManager = globalManagersWrapper.getResourcepackManager();
        this.uiManager = globalManagersWrapper.getUiManager();

        this.languageManager = languageManager;
        this.plugin = plugin;
        this.adventure = adventure;
    }

    public CacheManager getCacheManager() {
        return cacheManager;
    }

    public DebugManager getDebugManager() {
        return debugManager;
    }

    public LanguageManager getLanguageManager() {
        return languageManager;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public BukkitAudiences getAdventure() {
        return adventure;
    }

    public ParamParserManager getParamParserManager() {
        return paramParserManager;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public ResourcepackManager getResourcepackManager() {
        return resourcepackManager;
    }

    public UiManager getUiManager() {
        return uiManager;
    }
}
