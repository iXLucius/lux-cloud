package com.tencloud.lux.cache.api;

import java.util.List;

import com.tencloud.lux.cache.entity.CacheBean;

/**
 * 缓存API
 * <p/>
 * 解决问题：
 *
 */
public interface CacheAPI {
    /**
     * 传入key获取缓存json，需要用fastjson转换为对象
     *
     * @param key
     * @return
     */
    public String get(String key);

    /**
     * 保存缓存
     *
     * @param key
     * @param value
     * @param expireMin
     */
    public void set(String key, Object value, int expireMin);

    /**
     * 保存缓存
     *
     * @param key
     * @param value
     * @param expireMin
     * @param desc
     */
    public void set(String key, Object value, int expireMin, String desc);

    /**
     * 移除单个缓存
     *
     * @param key
     * @return
     */
    public Long remove(String key);

    /**
     * 移除多个缓存
     *
     * @param keys
     * @return
     */
    public Long remove(String... keys);

    /**
     * 按前缀移除缓存
     *
     * @param pre
     * @return
     */
    public Long removeByPre(String pre);

    /**
     * 通过前缀获取缓存信息
     *
     * @param pre
     * @return
     */
    public List<CacheBean> getCacheBeanByPre(String pre);

    /**
     * 获取所有缓存对象信息
     *
     * @return
     */
    public List<CacheBean> listAll();

    /**
     * 是否启用缓存
     *
     * @return
     */
    public boolean isEnabled();

    /**
     * 加入系统标志缓存
     *
     * @param key
     * @return
     */
    public String addSys(String key);
}
